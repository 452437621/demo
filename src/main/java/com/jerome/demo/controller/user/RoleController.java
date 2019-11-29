package com.jerome.demo.controller.user;

import com.jerome.demo.domain.Role;
import com.jerome.demo.domain.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleRepository roleDao;

    @RequestMapping("page")
    public Page<Role> page(int pageNum, int size, String roleName) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(pageNum, size, sort);
        Example<Role> example = Example.of(Role.builder().roleName(roleName).build());
        Page<Role> page = roleDao.findAll(example, pageable);
        return page;
    }

}
