package com.ra.controller;
import com.ra.entity.Product;
import com.ra.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

import java.util.Map;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<?> searchAndPaginateProduct(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String byTo,
            @PageableDefault(size = 2, page = 0, sort = "price") Pageable pageable) {
        Map<String, Object> data = new HashMap<>();
        Page<Product> searchResults;
        System.out.println(byTo);

        if (byTo != null) {
            searchResults = productService.sortByPrice(byTo, pageable);
        } else if (keyword != null) {
            searchResults = productService.searchAndPaginateProducts(keyword, pageable);
        } else {
            searchResults = productService.getPaging(pageable);
        }

        populateResponseData(data, searchResults);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    private void populateResponseData(Map<String, Object> data, Page<Product> searchResults) {
        data.put("products", searchResults.getContent());
        data.put("totalElements", searchResults.getTotalElements());
        data.put("pageSize", searchResults.getSize());
        data.put("totalPages", searchResults.getTotalPages());
    }


    @GetMapping("/searchByPrice")
    private  ResponseEntity< ?> getAllProductByPrice(
             @RequestParam(required = false) String start
            , @RequestParam(required = false) String end,
            @PageableDefault(size = 2, page = 0, sort = "price"
                    ,direction = Sort.Direction.ASC) Pageable pageable){
        return new ResponseEntity<>( productService.findAllByProductPrice(start,end,pageable), HttpStatus.OK);
    }
}

