package com.fg.network.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;


/**
 *解码器
 */
public class FixedLengthFrameDecoder extends ByteToMessageDecoder {
	private final int frameLength;

	public FixedLengthFrameDecoder(int frameLength){
		if(frameLength<=0){
			//	throw new IllegalAccessException ("frameLength must a positive integer: "+frameLength);
		}
		this.frameLength=frameLength;
	}
		 @Override
		 protected void decode(ChannelHandlerContext ctx,ByteBuf in,List<Object> out) throws Exception {
				 while(in.readableBytes()>=frameLength){
						 ByteBuf buf=in.readBytes(frameLength);
						 out.add(buf);
				 }	 
		 }
}

