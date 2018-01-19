package com.fg.network.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.TooLongFrameException;

import com.fg.network.message.Message;
import com.fg.network.message.TestMessage;
/**
 * 解码器
 */
public class CustomLengthFieldDecoder extends LengthFieldBasedFrameDecoder {
	//最大缓存数据
	private static final int MAX_FRAME_SIZE=1024;
	public CustomLengthFieldDecoder(int maxFrameLenth,int lengthFieldOffset,int lengthFieldLength){
		super(maxFrameLenth,lengthFieldOffset,lengthFieldLength);
	}
/**	public CustomLengthFieldDecoder(int maxFrameLength,int lengthFieldOffset,int lengthFieldLength,
					int lengthAdjustment,int initialBytesToStrip,boolean failFast){
	
	}*/
	@Override 
	protected ByteBuf  decode(ChannelHandlerContext  channelHandlerContext, ByteBuf  byteBuf) throws Exception {
		int readable=byteBuf.readableBytes();
		//检查缓冲区中是否有超过MAX_FRAME_SIZE个字节
		if(readable>MAX_FRAME_SIZE){
			//跳过所有的可读字节
			byteBuf.skipBytes();	
			throw new TooLongFrameException("Frame too big!");
		}
		return byteBuf;
	}
}

