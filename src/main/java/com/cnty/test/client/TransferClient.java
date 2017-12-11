package com.cnty.test.client;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/12/8 11:36
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Data
@Slf4j
public class TransferClient {
    private String server;
    private int port;
    private Socket client;

    public TransferClient(String server, int port) {
        this.server = server;
        this.port = port;
    }

    public void send(Map<String,Object> message) {
        try (ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream())) {
            oos.writeObject(message);
            log.info("Send message to server: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化Socket对象
     */
    public void init() {
        try {
            client = new Socket(server, port);
            log.info("Established a connection on " + client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
