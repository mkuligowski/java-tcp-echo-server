package com.mkuligowski.tcpsrv.managers;

import java.net.Socket;

public abstract class ThreadManager {
    public static ThreadManager newThreadManager(int threadCount) {
        if(threadCount > 0)
            return new PooledThreadManager(threadCount);
        return new NonPooledThreadManager();
    }

    public abstract void handleRequest(Socket socket);

}
