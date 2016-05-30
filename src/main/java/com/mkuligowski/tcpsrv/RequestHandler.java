package com.mkuligowski.tcpsrv;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by mkuligowski on 29.05.16.
 */
public class RequestHandler implements Runnable {


    private final Socket socket;
    private static final Logger LOG = LoggerFactory.getLogger(RequestHandler.class);

    public RequestHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        LOG.info("Request is handled by "+Thread.currentThread().getName());

        try {
            handleRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void handleRequest() throws IOException {
        InputStream input  = socket.getInputStream();
        byte[] bytes = IOUtils.toByteArray(input);
        OutputStream output = socket.getOutputStream();
        output.write(bytes);
        output.close();
        input.close();
    }
}
