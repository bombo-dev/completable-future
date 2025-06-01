package com.bombo.completableFuture.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DummyFacade {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private final DummyService dummyService;
    private final Executor newAsyncExecutor;

    public DummyFacade(DummyService dummyService, Executor newAsyncExecutor) {
        this.dummyService = dummyService;
        this.newAsyncExecutor = newAsyncExecutor;
    }

    public String execute() {
        log.info("execute Tomcat Default Thread: {}", Thread.currentThread().getName());
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(dummyService::a, newAsyncExecutor);
        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(dummyService::b, newAsyncExecutor);
        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(dummyService::c, newAsyncExecutor);
        CompletableFuture<String> futureD = CompletableFuture.supplyAsync(dummyService::d, newAsyncExecutor);

        return CompletableFuture.allOf(futureA, futureB, futureC, futureD)
                .thenApply(v -> {
                    String resultA = futureA.join();
                    String resultB = futureB.join();
                    String resultC = futureC.join();
                    String resultD = futureD.join();

                    return resultA + resultB + resultC + resultD;
                }).join();
    }
}
