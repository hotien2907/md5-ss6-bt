package com.ra.service;

import com.ra.entity.User;
import com.ra.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements  IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> sortByName(String order) {
        Sort.Direction direction = order.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return userRepository.findAll(Sort.by(direction, "userName"));
    }

    @Override
    public Page<User> getPaging(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> searchAndPaginateUsers(String key, Pageable pageable) {
        return userRepository.findAllByUserNameContainingIgnoreCase(key, pageable);
    }
}
