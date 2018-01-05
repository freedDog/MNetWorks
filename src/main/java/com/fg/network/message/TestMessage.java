package com.fg.network.message;

import io.netty.buffer.ByteBuf;

public class TestMessage extends Message{
	@Override
	public int getId() {
		return 0;	
	}
	@Override
	public String getQueue() {
		return "";
	}
	@Override
	public long getSendId() {
		return 0L;
	}
	@Override
	public int getSendTime() {
		return 0;
	}
	@Override
	public String getServer() {
		return "";
	}
	@Override
	public boolean read(ByteBuf  byteBuf) {
		return true;
	}
	@Override
	public boolean write(ByteBuf byteBuf) {
		return true;
	}
}

