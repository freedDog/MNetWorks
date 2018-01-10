package com.fg.network.decoder;

import org.junit.*;
import static junit.framework.Assert.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
//import com.fg.network.decoder.FixedLengthFrameDecoder;

public class FixedLengthFrameDecoderTest {
	/**@Test
	public void testFramesDecodes(){
		ByteBuf buf=Unpooled.buffer();
		for(int i=0;i<9;i++){
			buf.writeByte(i);		
		}
		ByteBuf input=buf.duplicate();
		EmbeddedChannel channel=new EmbeddedChannel(new FixedLengthFrameDecoder(3));
		assertTrue(channel.writeInbound(input.retain()));
		assertTrue(channel.finish());
		ByteBuf read=(ByteBuf)channel.readInbound();
		assertEquals(buf.readSlice(3),read);
		read.release();

		read=(ByteBuf)channel.readInbound();
		assertEquals(buf.readSlice(3),read);
		read.release();

		read=(ByteBuf)channel.readInbound();
		assertEquals(buf.readSlice(3),read);
		read.release();
	}
	@Test
	public void testFramesDecoder2(){
		ByteBuf buf=Unpooled.buffer();
		for(int i=0;i<9;i++){
			buf.writeByte(i);	
		}
		ByteBuf input=buf.duplicate();

		EmbeddedChannel channel=new EmbeddedChannel(
						new FixedLengthFrameDecoder(3));
		assertFalse(channel.writeInbound(input.readBytes(2)));
		assertTrue(channel.writeInbound(input.readBytes(7)));

		assertTrue(channel.finish());
		ByteBuf read=(ByteBuf)channel.readInbound();
		assertEquals(buf.readSlice(3),read);
		read.release();
		
		read=(ByteBuf)channel.readInbound();
		assertEquals(buf.readSlice(3),read);
		read.release();

		read=(ByteBuf)channel.readInbound();
		assertEquals(buf.readSlice(3),read);
		read.release();

		assertNull(channel.readInbound());
		buf.release();
	}*/
}

