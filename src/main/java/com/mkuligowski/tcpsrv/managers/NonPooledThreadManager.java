package com.mkuligowski.tcpsrv.managers;

import com.mkuligowski.tcpsrv.RequestHandler;

import java.net.Socket;

public class NonPooledThreadManager extends ThreadManager {
    @Override
    public void handleRequest(Socket socket) {


        new Thread(new RequestHandler(socket)).start();

    }
}
