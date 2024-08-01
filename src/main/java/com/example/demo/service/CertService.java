package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class CertService {

    @Async
    public CompletableFuture<String> certProcess(final long memberId) {

        String result = "false";
        try {
            Thread.sleep(500);
            result = "true";
        } catch (InterruptedException ie) {
            System.out.printf("CertService::certProcess::InterruptedException {}", ie);
            Thread.currentThread().interrupt();
        }
        return CompletableFuture.completedFuture(result);
    }
}
