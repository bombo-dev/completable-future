package com.bombo.completableFuture.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public String a() {
        log.info("Thread {} is executing method a", Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Method a completed in thread {}", Thread.currentThread().getName());
        return "A";
    }

    public String b() {
        log.info("Thread {} is executing method b", Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Method b completed in thread {}", Thread.currentThread().getName());
        return "B";
    }

    public String c() {
        log.info("Thread {} is executing method c", Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Method c completed in thread {}", Thread.currentThread().getName());
        return "C";
    }

    public String d() {
        log.info("Thread {} is executing method d", Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Method d completed in thread {}", Thread.currentThread().getName());
        return "D";
    }

}
