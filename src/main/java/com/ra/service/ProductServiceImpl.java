package com.ra.service;
import com.ra.entity.Product;
import com.ra.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class ProductServiceImpl  implements  IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Page<Product> searchAndPaginateProducts(String key, Pageable pageable) {
        return productRepository.findAllByProductNameContainingIgnoreCase(key,pageable);
    }

    @Override
    public Page<Product> sortByPrice(String by,Pageable pageable) {
       return productRepository.sortProductByPrice(by,pageable);
    }

    @Override
    public Page<Product> getPaging(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findAllByProductPrice(String start, String end, Pageable pageable) {
        return productRepository.findAllByProductPrice(start,end,pageable);
    }
}
