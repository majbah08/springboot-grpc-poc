package com.majbah.springgrpcpoc.service;

import com.majbah.springgrpcpoc.BookGrpc;
import com.majbah.springgrpcpoc.BookService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookServiceImpl extends BookGrpc.BookImplBase {

    @Override
    public void create(BookService.BookCreateRequest req, StreamObserver<BookService.BookCreateResponse> responseObserver) {
        log.info("Got request from client: " + req);
        BookService.BookCreateResponse reply = BookService.BookCreateResponse.newBuilder()
                .setBookName(req.getBookName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
