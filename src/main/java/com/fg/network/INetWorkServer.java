package com.fg.network;

import io.netty.channel.ChannelHandlerContext;

import com.fg.network.message.Message;
/**
 * 网络基础接口处理连接和消息
 */
public abstract interface INetWorkServer {
	public abstract void doCommand(ChannelHandlerContext ctx,Message msg);
	public abstract void channelRegistered(ChannelHandlerContext ctx);
	public abstract void channelActive(ChannelHandlerContext ctx) throws Exception;
	public abstract void exceptionCauth(ChannelHandlerContext ctx,Throwable trhowable) throws Exception;
}

