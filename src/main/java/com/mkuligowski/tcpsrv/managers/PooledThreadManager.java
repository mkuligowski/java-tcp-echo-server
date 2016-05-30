package com.mkuligowski.tcpsrv.managers;

import com.mkuligowski.tcpsrv.RequestHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PooledThreadManager extends ThreadManager {

    private static final Logger LOG = LoggerFactory.getLogger(PooledThreadManager.class);

    private ExecutorService executorService;

    public PooledThreadManager(int threadCount) {
        this.executorService = Executors.newFixedThreadPool(threadCount);
    }

    @Override
    public void handleRequest(Socket socket) {
        LOG.info("Pooled thread manager delegates request to request handler");
        executorService.execute(new RequestHandler(socket));
    }
}
