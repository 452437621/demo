package com.jerome.demo.controller.user;

import com.jerome.demo.domain.User;
import com.jerome.demo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userDao;

    @RequestMapping("page")
    public Page<User> page(int pageNum, int size, User user) {
        Example<User> example = Example.of(user);
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageAble = PageRequest.of(pageNum, size, sort);
        Page<User> page = userDao.findAll(example, pageAble);
        return page;
    }

    @RequestMapping("getById")
    public User getById(long id) {
        Optional<User> userOptional = userDao.findById(id);
        return userOptional.get();
    }

    @RequestMapping("save")
    public User save(User user) {
        User newUser = userDao.save(user);
        return newUser;
    }

}
