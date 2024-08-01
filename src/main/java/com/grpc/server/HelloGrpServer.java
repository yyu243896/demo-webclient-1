package com.grpc.server;


import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class HelloGrpServer {

    public static void main(String[] args) throws InterruptedException, IOException {

        Server grpServer = ServerBuilder.forPort(9000)
                .addService(new HelloServiceImpl())
                .build();
        grpServer.start();
        grpServer.awaitTermination();


    }
}
