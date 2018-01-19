package com.fg.network.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

import com.fg.network.INetWorkServer;
import com.fg.network.message.Message;
import com.fg.network.message.TestMessage;

public final  class LengthFrameInHandler extends ChannelInboundHandlerAdapter {
		private INetWorkServer ioServer;
		public LengthFrameInHandler(INetWorkServer netWorkServer){
			this.ioServer=netWorkServer;
		}
		@Override
		public void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
			System.out.println("server registered");
			this.ioServer.channelRegistered(channelHandlerContext);
		}
		@Override
		public void channelUnregistered(ChannelHandlerContext channelHandlerContext) throws Exception {
			System.out.println("server unregistered");
		}	
		@Override
		public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
			System.out.println("server inactive");
			this.ioServer.channelActive(channelHandlerContext);
		}
		@Override
		public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
			System.out.println("server read complete");
		}
		@Override
		public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
				System.out.println("server write changed");
		}
		@Override
		public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
				System.out.println("server user event ");
		}
		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
				//处理帧的数据
				this.ioServer.doCommand(ctx,(ByteBuf)msg);
		}
		@Override
		public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
			throwable.printStackTrace();	
			this.ioServer.exceptionCauth(channelHandlerContext,throwable);
		}
		@Override
		public void channelActive(ChannelHandlerContext ctx)throws Exception{
			System.out.println("server active ");		
		}
}

