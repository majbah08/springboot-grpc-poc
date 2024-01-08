package com.majbah.springgrpcpoc;

import com.majbah.springgrpcpoc.service.GrpcServer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringGrpcPocApplication {

    private final GrpcServer grpcServer;

    @Value("${grpc.server.port}")
    private int grpcPort;

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(SpringGrpcPocApplication.class, args)
                .getBean(SpringGrpcPocApplication.class)
                .runGrpcServer();
    }

    public void runGrpcServer() throws IOException, InterruptedException {
        grpcServer.start(grpcPort);

    }
}
