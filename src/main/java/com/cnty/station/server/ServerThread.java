package com.cnty.station.server;

import com.cnty.station.pojo.Transfer;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/12/5 13:57
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Slf4j
public class ServerThread implements Runnable {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    ServerThread(Socket socket) throws IOException {
        ois = new ObjectInputStream(socket.getInputStream());
        oos = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try (PrintWriter pw = new PrintWriter(oos, true)) {
            Transfer transfer = (Transfer) ois.readObject();
            log.info("Accept message from client : " + transfer);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
