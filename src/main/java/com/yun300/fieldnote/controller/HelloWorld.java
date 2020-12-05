package com.yun300.fieldnote.controller;

import com.yun300.fieldnote.model.HelloModel;
import com.yun300.fieldnote.model.ReqBody;
import com.yun300.fieldnote.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class HelloWorld {
    private final com.yun300.fieldnote.service.HelloService HelloService;

    @Autowired
    public HelloWorld(HelloService HelloService) {
        this.HelloService = HelloService;

    }

    @RequestMapping("/")
    public String Index() {
        return "Hello World";
    }

    @RequestMapping("/list")
    public List<HelloModel> List() {
        return HelloService.selectAll();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String Post(
            @RequestBody ReqBody map
    ) throws  IOException {
        return "输入的姓名是" + map.getName() + ",电子邮件是:" + map.getEmail();
    }
}
