package me.samuel.jenkinstest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jenkins")
public class JenkinsTestController {

    @GetMapping("/test")
    public String test(){
        System.out.println("Jenkins Test!");
        return "Jenkins Test!";
    }
}
