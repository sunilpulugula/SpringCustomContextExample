package com.spring.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.product.model.Product;

/**
 * @author <a href="mailto:sunil.pulugula@wavemaker.com">Sunil Kumar</a>
 * @since 13/9/16
 */
@RestController
public class ProductsController {


    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> listProducts() {

        this.getClass().getClassLoader().getResource("");
        List<Product> products = new ArrayList<>();
        products.add(new Product("product1", "product1", 100));
        products.add(new Product("product2","product2",200));
        products.add(new Product("product3","product3",300));
        products.add(new Product("product4","product4",400));

        return products;
    }

    public static void main(String[] args) {
        new ProductsController().listProducts();
    }
}
