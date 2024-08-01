package com.grpc.server;

import com.grpc.GreeterGrpc;
import com.grpc.HelloReply;
import com.grpc.HelloRequest;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {

        String getAddress = "서울 강남구 역삼동 110번지";

        String sendName = request.getName();

        HelloReply helloReply = HelloReply.newBuilder()
                .setMessage("request : " + getAddress)
                .build();

        responseObserver.onNext(helloReply);
    }
}
