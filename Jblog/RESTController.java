package com.project.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {
    //get(select)
    @GetMapping("/jblog")
    public String httpGet() {
        return "get 요청 처리";
    }

    //post(insert)
    @PostMapping("/jblog")
    public String httpPost() {
        return "post 요청 처리";
    }

    //put(update)
    @PutMapping("/jblog")
    public String httpPut() {
        return "put 요청 처리";
    }

    //delete(delete)
    @DeleteMapping("/jblog")
    public String httpDelete() {
        return "delete 요청 처리";
    }
}
