package com.ra.repository;

import com.ra.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    Page<User> findAllByUserNameContainingIgnoreCase(String keyword, Pageable pageable);
}
