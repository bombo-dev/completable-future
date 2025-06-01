package com.bombo.completableFuture.controller;

import com.bombo.completableFuture.service.DummyFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final DummyFacade dummyFacade;

    public TestController(DummyFacade dummyFacade) {
        this.dummyFacade = dummyFacade;
    }

    @GetMapping("/test")
    public String test() {
        return dummyFacade.execute();
    }
}
