package io.rest;

import io.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class restProduct {

    @GetMapping("")
    public Product getProduct() {
        Product product = new Product();
        return product;
    }

    @PostMapping("")
    public void postProduct() {

    }
}
