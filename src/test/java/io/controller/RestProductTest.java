package io.controller;

import io.app.Application;
import io.document.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootTest(classes = Application.class)
public class RestProductTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ProductController productController;

    @BeforeSuite
    public void beforeSuite() {
    }

    @BeforeMethod
    public void setUp() {
        productController.postProduct(new Product("1","One","Brand 1","describing number uno", new String[]{null}));
        productController.postProduct(new Product("2","Two","Brand 2","describing number dos", new String[]{"dev"}));
        productController.postProduct(new Product(null,"Three", "Brand 3", "describing number 3", new String[]{null}));
        productController.postProduct(new Product(null,null, null, null, null));
    }

    @Test
    public void testGetProductById() {
        Product productInput = new Product("1","One","Brand 1","describing number uno", new String[]{null});
        productController.postProduct(productInput);
        Optional<Product> productOutputOptional = productController.getProductById(productInput.id);
        assert productOutputOptional.isPresent();
        Product productOutput = productOutputOptional.get();
        assert productOutput.name.equals(productInput.name);
    }

    @Test
    public void testGetProductByName() {
        Product productInput = new Product("2","Two","Brand 2","describing number dos", new String[]{"dev"});
        productController.postProduct(productInput);
        Product productOutput = productController.getProductByName(productInput.name).get();
        assert productOutput.id.equals(productInput.id);
    }

    @Test
    public void testPostProduct() {
        assert productController.getProductByName("One").isPresent();
        Product productInput = new Product("1","One","Brand 1","describing number uno", new String[]{null});
        productController.postProduct(productInput);
    }

}