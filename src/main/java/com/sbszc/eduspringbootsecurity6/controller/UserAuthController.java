package com.sbszc.eduspringbootsecurity6.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthController {

    @PostMapping("write")
//    @PreAuthorize("hasAnyAuthority('write')")
    public String write() {
        return "write";
    }

    @GetMapping("read")
//    @PreAuthorize("hasAnyAuthority('read')")
    public String read() {
        return "read";
    }

    @GetMapping("ping")
//    @PreAuthorize("permitAll()")
    public String ping() {
        return "ping";
    }
}
