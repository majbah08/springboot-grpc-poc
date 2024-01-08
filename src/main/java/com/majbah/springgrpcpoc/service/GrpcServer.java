package com.majbah.springgrpcpoc.service;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class GrpcServer {
    private Server server;
    public void start( int port) throws IOException, InterruptedException {
        server = ServerBuilder.forPort(port).addService(new BookServiceImpl ()).build().start();

        log.info("Server started, listening on " + port);

        server.awaitTermination();

    }

}
