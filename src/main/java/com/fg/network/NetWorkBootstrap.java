package com.fg.network;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import com.fg.network.INetWorkServer;
import com.fg.network.handler.LengthBasedinitializer;
public class NetWorkBootstrap {
	private final int port;
	private INetWorkServer ioServer;
	//设置服务器用于处理channel事件的EventLoop
	private EventLoopGroup grop;

	public NetWorkBootstrap(int port,INetWorkServer ioServer){
		this.port=port;
		this.ioServer=ioServer;
	}
	/**
	 * 开启网络连接
	 */
	public void start() throws Exception {
		EventLoopGroup group=new NioEventLoopGroup();
		try{
				ServerBootstrap b=new ServerBootstrap();
				b.group(group)
						.channel(NioServerSocketChannel.class)
						.localAddress(new InetSocketAddress(port));
				b.childHandler(new LengthBasedinitializer(this.ioServer));
				ChannelFuture f=b.bind().sync();
				f.channel().closeFuture().sync();
				
		
		}finally{
			group.shutdownGracefully().sync();
		}	
	
	}
	/**
	 * 关闭所有的连接
	 */
	public void stop(){
	
	}
}

