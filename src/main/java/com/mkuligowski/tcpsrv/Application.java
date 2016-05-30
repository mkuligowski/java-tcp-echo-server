package com.mkuligowski.tcpsrv;


public class Application {
    public static void main(String[] args) {

        Configuration configuration = loadConfiguration(args);
        TCPEchoServer tcpEchoServer = new TCPEchoServer(configuration);
        tcpEchoServer.start();

    }

    private static Configuration loadConfiguration(String[] args) {
        return args.length > 0 ?
                Configuration.newCustomConfiguration(args):
                Configuration.defaultConfiguration();
    }
}
