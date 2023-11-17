package net.bobdb.productservice.services;


import net.bobdb.productservice.models.Product;
import net.bobdb.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
      return productRepository.findAll();
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }
}
