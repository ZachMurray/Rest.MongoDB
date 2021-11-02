package io.controller;

import io.document.Product;
import io.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/All")
    public List<Product> getProductAll() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/By/Id/{productId}")
    public Optional<Product> getProductById(@PathVariable String productId) {
        return productRepository.findById(String.valueOf(productId));
    }

    @GetMapping(path = {"/By/Name/{productName}"})
    public Optional<Product> getProductByName(@PathVariable("productName") String productName) {
        return productRepository.findByName(productName);
    }

    @PostMapping(path = "")
    public Product postProduct(@RequestBody Product product) {
        product = (product == null) ? new Product(null,null,null,null,null) : product;
        productRepository.save(product);
        return product;
    }
}
