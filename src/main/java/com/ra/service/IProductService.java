package com.ra.service;

import com.ra.entity.Product;
import com.ra.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> searchAndPaginateProducts(String key, Pageable pageable);
//    Page<Product> sortByPrice(String order);
    Page<Product> getPaging(Pageable pageable);
    Page<Product> findAllByProductPrice(String start,String end, Pageable pageable);
   Page<Product> sortByPrice(String by,Pageable pageable);

}
