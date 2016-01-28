package io.nerd.rpc.core.remoting.netty;

import io.nerd.rpc.core.remoting.RpcRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.nerd.rpc.core.remoting.RpcResponse;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The type Netty rpc client.
 */
public class NettyRpcClient extends SimpleChannelInboundHandler<RpcResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyRpcClient.class);

    private String host;
    private int port;

    private RpcResponse response;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition signal = lock.newCondition();
    private final Object obj = new Object();

    /**
     * Instantiates a new Netty rpc client.
     *
     * @param host the host
     * @param port the port
     */
    public NettyRpcClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, RpcResponse response) throws Exception {
        this.response = response;

        try {
            lock.lock();
            signal.signal();
        }finally {
            lock.unlock();
        }
        /*synchronized (obj) {
            obj.notifyAll(); // 收到响应，唤醒线程
        }*/
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        LOGGER.error("client caught exception", cause);
        ctx.close();
    }

    /**
     * Send rpc response.
     *
     * @param request the request
     * @return the rpc response
     * @throws Exception the exception
     */
    public RpcResponse send(RpcRequest request) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel channel) throws Exception {
                        channel.pipeline()
                            .addLast(new NettyRpcEncoder(RpcRequest.class)) // 将 RPC 请求进行编码（为了发送请求）
                            .addLast(new NettyRpcDecoder(RpcResponse.class)) // 将 RPC 响应进行解码（为了处理响应）
                            .addLast(NettyRpcClient.this); // 使用 NettyRpcClient 发送 RPC 请求
                    }
                })
                .option(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture future = bootstrap.connect(host, port).sync();
            future.channel().writeAndFlush(request).sync();

            try {
                lock.lock();
                signal.await();
            } finally {
                lock.unlock();
            }
            /*synchronized (obj) {
                obj.wait(); // 未收到响应，使线程等待
            }*/

            if (response != null) {
                future.channel().closeFuture().sync();
            }
            return response;
        } finally {
            group.shutdownGracefully();
        }
    }
}