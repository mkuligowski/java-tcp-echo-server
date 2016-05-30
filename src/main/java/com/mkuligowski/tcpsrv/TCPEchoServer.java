package com.mkuligowski.tcpsrv;


import com.mkuligowski.tcpsrv.managers.ThreadManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * Created by mkuligowski on 29.05.16.
 */
public class TCPEchoServer {

    static final Logger LOG = LoggerFactory.getLogger(TCPEchoServer.class);

    private Configuration configuration;
    private ServerSocket serverSocket;
    private ExecutorService executorService;


    public TCPEchoServer(Configuration configuration) {
        this.configuration = configuration;
    }

    public void start(){
        LOG.info(String.format("Starting TCP Server on %s port",configuration.getPort()));

        ThreadManager threadManager = ThreadManager.newThreadManager(configuration.getThreadCount());

        openServerSocket();

        while(true){
            LOG.info("Waiting for client!");
            try {
                Socket clientSocket = serverSocket.accept();
                LOG.info("Client connected!");
                threadManager.handleRequest(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }








    }

    private void openServerSocket() {
        try {
            serverSocket = new ServerSocket(configuration.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
