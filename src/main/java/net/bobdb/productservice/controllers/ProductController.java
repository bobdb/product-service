package net.bobdb.productservice.controllers;

import lombok.extern.slf4j.Slf4j;

import net.bobdb.productservice.dto.ProductRequest;
import net.bobdb.productservice.dto.ProductResponse;
import net.bobdb.productservice.mappers.ProductMapper;
import net.bobdb.productservice.models.Product;

import net.bobdb.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> findAll() {
        List<Product> allProducts = productService.findAll();
        return allProducts.stream().map(ProductMapper::mapToResponse).toList();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(ProductMapper.mapToObject(productRequest));
        log.info("Product {} is saved again", productRequest.getName());
    }

}
