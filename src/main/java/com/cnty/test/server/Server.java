package com.cnty.test.server;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/12/1 15:20
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Slf4j
public class Server {

    private ServerSocket serverSocket;

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("pool-%d").build();

    private static ExecutorService executorService = new ThreadPoolExecutor(
            5, 200, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
            threadFactory, new ThreadPoolExecutor.AbortPolicy());

    public Server() {
        try {
            int port = 10010;
            // 监听10010端口
            serverSocket = new ServerSocket(port);
            log.info("Server started on " + serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        //noinspection InfiniteLoopStatement
        while (true) {
            Socket socket;
            try {
                //开始监听,等待客户端的连接
                socket = serverSocket.accept();
                log.info("新客户端: " + socket + "[已连接]");
                // 将输入、输出交给线程处理
                executorService.execute(new ServerThread(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
