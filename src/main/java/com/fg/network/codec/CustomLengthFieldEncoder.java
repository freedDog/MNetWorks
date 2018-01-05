package com.fg.network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import com.fg.network.message.Message;
/**
 * 编码器
 */
public class CustomLengthFieldEncoder extends MessageToByteEncoder<Message> {
	@Override 
	public void encode(ChannelHandlerContext channelHandlerContext, Message msg, ByteBuf  byteBuf) throws Exception {
		System.out.println("encode:");	
		//msg.write(byteBuf);	
		//byteBuf.release();
	}
}

