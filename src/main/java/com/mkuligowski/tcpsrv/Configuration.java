package com.mkuligowski.tcpsrv;

/**
 * Created by mkuligowski on 29.05.16.
 */
public class Configuration {
    private int port;
    private int threadCount;


    private Configuration(int port, int threadCount){
        this.port = port;
        this.threadCount = threadCount;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "port=" + port +
                ", threadCount=" + threadCount +
                '}';
    }

    public static Configuration newCustomConfiguration(String[] args) {
        return new Configuration(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }


    public static Configuration defaultConfiguration() {
        return new Configuration(9000,10);
    }
}
