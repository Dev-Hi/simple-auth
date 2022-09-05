package com.dev.hi.slow.auth.controller;

import com.dev.hi.slow.auth.model.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@RestController
@RequestMapping("/foos")
@Slf4j
public class FooController {

    @GetMapping(value = "/{id}")
    public Foo getFoo(@PathVariable Long id) {
        return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
    }

    @GetMapping
    public List<Foo> findAll() {
        return List.of(
                new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4)),
                new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4)),
                new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4))
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Foo newFoo) {
        log.info("Foo has been created.");
    }

}
