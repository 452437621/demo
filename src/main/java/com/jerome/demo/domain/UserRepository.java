package com.jerome.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String password);

    List<User> findAllByEmail(String email);

}
