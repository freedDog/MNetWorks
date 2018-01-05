package com.fg.network.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import com.fg.network.INetWorkServer;
import com.fg.network.codec.CustomLengthFieldDecoder;
import com.fg.network.codec.CustomLengthFieldEncoder;
import com.fg.network.handler.LengthFrameInHandler;
import com.fg.network.handler.LengthFrameOutHandler;
public class LengthBasedinitializer extends ChannelInitializer<Channel> {
	//消息的容量
	public static final int maxFrameLength=64*1024;
	//偏移量
	public static final int lengthFieldOffset=0;
	//帧的长度陪编码到帧起始前8个字节中
	public static final int lengthFieldLength=8;
	private INetWorkServer ioServer;
	public LengthBasedinitializer(INetWorkServer ioServer){
		this.ioServer=ioServer;	
	}
	@Override 
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline=ch.pipeline();
		pipeline.addLast("decoder",new CustomLengthFieldDecoder(maxFrameLength,lengthFieldOffset,lengthFieldLength));
		pipeline.addLast("InHandler",new LengthFrameInHandler(this.ioServer));
		pipeline.addLast("OutHandler",new LengthFrameOutHandler());
		pipeline.addLast("encoder",new CustomLengthFieldEncoder());
	}
}

