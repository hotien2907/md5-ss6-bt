package com.ra.controller;

import com.ra.entity.User;
import com.ra.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("/ti-nua-lam")
    public ResponseEntity<?> getAll(@RequestParam(required = false) String order){
        if(order !=null){
            List<User> list= userService.sortByName(order);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
      List<User> list= userService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<Map<String, Object>> paginateUsers(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "2") int pageSize) {
//        Pageable pageable = PageRequest.of(page, pageSize);
//        Page<User> userPage = userService.getPaging(pageable);
//        Map<String, Object> data = new HashMap<>();
//        data.put("users", userPage.getContent());
//        data.put("totalElements", userPage.getTotalElements());
//        data.put("pageSize", userPage.getSize());
//        data.put("totalPages", userPage.getTotalPages());
//        return new ResponseEntity<>(data, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<?> searchAndPaginateUsers(
            @RequestParam(required = false) String order,
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int pageSize) {

        if (order != null) {
            List<User> sortedList = userService.sortByName(order);
            return new ResponseEntity<>(sortedList, HttpStatus.OK);
        } else if (keyword != null) {
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<User> searchResults = userService.searchAndPaginateUsers(keyword, pageable);
            Map<String, Object> data = new HashMap<>();
            data.put("users", searchResults.getContent());
            data.put("totalElements", searchResults.getTotalElements());
            data.put("pageSize", searchResults.getSize());
            data.put("totalPages", searchResults.getTotalPages());
            return new ResponseEntity<>(data, HttpStatus.OK);
        } else {
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<User> userPage = userService.getPaging(pageable);
            Map<String, Object> data = new HashMap<>();
            data.put("users", userPage.getContent());
            data.put("totalElements", userPage.getTotalElements());
            data.put("pageSize", userPage.getSize());
            data.put("totalPages", userPage.getTotalPages());
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
    }

}
