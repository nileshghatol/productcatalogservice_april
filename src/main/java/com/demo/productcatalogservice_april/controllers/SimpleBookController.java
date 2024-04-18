package com.demo.productcatalogservice_april.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

// We annotated the request handling method with @ResponseBody.
// This annotation enables automatic serialization of the return object into the HttpResponse.
@Controller
@RequestMapping("books")
public class SimpleBookController {

    @GetMapping(value = "{id}", produces = "application/json")
    public @ResponseBody Book getBook(@PathVariable Long id) {
        return new Book();
    }
}


//The controller is annotated with the @RestController annotation; therefore,
// the @ResponseBody isn’t required.
//Every request handling method of the controller class automatically serializes return objects
// into HttpResponse.
@RestController
@RequestMapping("book-rest")
class SimpleBookControllerRestController {

    @GetMapping(value = "{id}", produces = "application/json")
    public Book getBook(@PathVariable Long id) {
        return new Book();
    }
}
