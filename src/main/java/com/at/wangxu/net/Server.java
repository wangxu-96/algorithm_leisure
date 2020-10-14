package com.at.wangxu.net;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

// 开启一个channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
// 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
// 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(PORT));
// 打开一个多路复用器
        Selector selector = Selector.open();
// 绑定多路复用器和channel
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
// 获取到达的事件
        while (selector.select() > 0) {
            Set<SelectionKey> keys = selector.keys();
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    // 处理逻辑

                }
                if (selectionKey.isReadable()) {
                    // 处理逻辑
                    ByteBuffer allocate = ByteBuffer.allocate(10);
                }
            }
        }
    }
}
