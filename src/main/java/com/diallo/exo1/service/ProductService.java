package com.diallo.exo1.service;


import com.diallo.exo1.entity.Product;
import com.diallo.exo1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).get();
    }
}
