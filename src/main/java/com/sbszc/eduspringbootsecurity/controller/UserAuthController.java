package com.sbszc.eduspringbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    @GetMapping("find")
    public String find() {
        return "find";
    }

    @GetMapping("save")
    public String save() {
        return "save";
    }

    @GetMapping("ping")
    public String ping() {
        return "ping";
    }
}
