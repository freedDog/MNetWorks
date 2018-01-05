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
	public NetWorkBootstrap(int port,INetWorkServer ioServer){
		this.port=port;
		this.ioServer=ioServer;
	}
	public static void main(String[] args){
		if(args.length!=1){
			System.out.println("Usage:"+NetWorkBootstrap.class.getSimpleName()+" ");	
		}
		int port=Integer.parseInt(args[0]);
		try{
			//new NetWorkBootstrap(port).start();
			System.out.println("server start");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
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
}

