package com.fg.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

import com.fg.network.EchoClientHandler;

public class EchoClient {
	private final String host;
	private final int port;

	public EchoClient(String host,int port){
		this.host=host;
		this.port=port;
	}
	public void start() throws Exception{
		EventLoopGroup  group=new NioEventLoopGroup ();
		try{
				Bootstrap b=new Bootstrap();
				b.group(group);
				b.channel(NioSocketChannel.class);
				b.remoteAddress(new InetSocketAddress(this.host,this.port));
				b.handler(new ChannelInitializer<SocketChannel>(){
					@Override 
					protected void initChannel(SocketChannel ch)
						throws Exception {
						ch.pipeline().addLast(new EchoClientHandler ());
					}
				});
				ChannelFuture f=b.connect().sync();
				f.channel().closeFuture().sync();
		} finally{
			group.shutdownGracefully().sync();	
		}
	}
	public static void main(String[] args) throws Exception{
		if(args.length!=2){
			System.out.println("usage: "+EchoClient.class.getSimpleName()+"<host><port>");
			return;
		}
		String host=args[0];
		int port=Integer.parseInt(args[1]);
		new EchoClient(host,port).start();	
	}
}

