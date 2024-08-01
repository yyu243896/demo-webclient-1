package com.client;

import com.grpc.GreeterGrpc;
import com.grpc.HelloReply;
import com.grpc.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloGrpClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9000)
                .usePlaintext()
                .build();

        String _name = "Mingki";
        GreeterGrpc.GreeterBlockingStub blockingSt = GreeterGrpc.newBlockingStub(channel);
        HelloReply helloReply = blockingSt.sayHello(HelloRequest.newBuilder()
                .setName(_name)
                .build());

        System.out.println("blockingSt = " + helloReply.getMessage());

        channel.isShutdown();
    }
}
