package dev.ruster.app.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Tag(name = "Hello World", description = "The Hello World API")
    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World!";
    }
}
