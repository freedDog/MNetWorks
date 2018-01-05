package com.fg.network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import com.fg.network.message.Message;
import com.fg.network.message.TestMessage;
/**
 * 解码器
 */
public class CustomLengthFieldDecoder extends LengthFieldBasedFrameDecoder {
	public CustomLengthFieldDecoder(int maxFrameLenth,int lengthFieldOffset,int lengthFieldLength){
		super(maxFrameLenth,lengthFieldOffset,lengthFieldLength);
	}
/**	public CustomLengthFieldDecoder(int maxFrameLength,int lengthFieldOffset,int lengthFieldLength,
					int lengthAdjustment,int initialBytesToStrip,boolean failFast){
	
	}*/
	@Override 
	protected Message  decode(ChannelHandlerContext  channelHandlerContext, ByteBuf  byteBuf) throws Exception {
		int i=byteBuf.readInt();
		System.out.println("decode:"+i);
		return new TestMessage();
	}
}

