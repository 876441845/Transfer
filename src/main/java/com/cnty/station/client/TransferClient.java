package com.cnty.station.client;

import com.cnty.station.pojo.Transfer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

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

    public void send(Transfer transfer) {
        try (ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream())) {
            oos.writeObject(transfer);
            log.info("Send message to server: " + transfer);
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
