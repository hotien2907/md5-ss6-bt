package com.ra.service;

import com.ra.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User>  findAll( );
    List<User> sortByName(String order);
         Page<User> getPaging(Pageable pageable);
       Page<User>   searchAndPaginateUsers(String key,Pageable pageable);
}
