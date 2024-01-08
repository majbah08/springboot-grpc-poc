package com.majbah.springgrpcpoc.service;


import com.majbah.springgrpcpoc.BookService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BookServer {
    private Server server;
    private void start() throws IOException {
        int port = 50051;
        server = ServerBuilder.forPort(port).addService(new BookServiceImpl ()).build().start();

        log.info("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("Shutting down gRPC server");
                try {
                    server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

}
