package com.fg.network.decoder;

import org.junit.*;
import static junit.framework.Assert.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
//import com.fg.network.decoder.AbsIntegerEncoder;

public class AbsIntegerEncoderTest {

	/**@Test 
	public void testEncoded(){
		ByteBuf buf=Unpooled.buffer();
		for(int i=0;i<10;i++){
			buf.writeInt(i*-1);	
		}	
		EmbeddedChannel channel=new EmbeddedChannel(new AbsIntegerEncoder());
		assertTrue(channel.writeOutbound(buf));
		assertTrue(channel.finish());
		
		for(int i=0;i<10;i++){
			assertEquals(i,(int)channel.readOutbound());
		}	
		assertNull(channel.readOutbound());
	}*/
}

