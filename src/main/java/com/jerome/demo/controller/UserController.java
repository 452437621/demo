package com.jerome.demo.controller;

import com.jerome.demo.domain.User;
import com.jerome.demo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userDao;

    @RequestMapping("page")
    public Page<User> page(int pageNum, int size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageAble = PageRequest.of(pageNum, size, sort);
        Page<User> page = userDao.findAll(pageAble);
        return page;
    }

    @RequestMapping("getById")
    public User getById(long id) {
        Optional<User> userOptional = userDao.findById(id);
        return userOptional.get();
    }

    public User save(User user) {
        User newUser = userDao.save(user);
        return newUser;
    }


}
