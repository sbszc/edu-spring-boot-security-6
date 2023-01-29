package com.sbszc.eduspringbootsecurity6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    @PostMapping("write")
    public String write() {
        return "write";
    }

    @GetMapping("read")
    public String read() {
        return "read";
    }

    @GetMapping("ping")
    public String ping() {
        return "ping";
    }
}
