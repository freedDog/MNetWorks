package com.fg.network.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;

import com.fg.network.message.Message;

public class LengthFrameOutHandler extends ChannelOutboundHandlerAdapter {
	@Override
	public void bind(ChannelHandlerContext channelHandlerContext, SocketAddress  socketAddress, ChannelPromise channelPromise) throws Exception {
			System.out.println("server bind");
	}
	@Override
	public void connect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress1, SocketAddress socketAddress2, ChannelPromise channelPromise) throws Exception {
			System.out.println("server connect");
	}
	@Override
	public void disconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
			System.out.println("server disconnect");
	}
	@Override
	public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
			System.out.println("server close");
	}
	@Override
	public void deregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
			System.out.println("server deregister");
	}
	@Override
	public void read(ChannelHandlerContext channelHandlerContext) throws Exception {
			super.read(channelHandlerContext);
			System.out.println("server read :");
	}
	@Override
	public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
			System.out.println("server flush");
	}
	@Override
	public void write(ChannelHandlerContext  ctx, Object object, ChannelPromise  channelPromise) throws Exception {
		//super.waite(ctx,object,channelPromise);
		//Channel channel=ctx.channel();
		//ByteBufAllocator allocator=channel.alloc();
		//ByteBuf buf=allocator.buffer();
		//buf.writeInt(2);
		//ctx.write(buf);
		ctx.writeAndFlush(object);
		//ctx.writeAndFlush(new TestMessage());
		System.out.println("server write ");
	}
}

