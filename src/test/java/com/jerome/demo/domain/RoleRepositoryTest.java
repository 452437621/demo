package com.jerome.demo.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testSave() throws Exception {
        // delete all
        this.roleRepository.deleteAll();
        // save
        Date regTime = new Date();
        List<Role> roleList = new ArrayList<Role>(3);
        roleList.add(Role.builder().roleName("系统管理员").regTime(regTime).build());
        roleList.add(Role.builder().roleName("用户管理员").regTime(regTime).build());
        roleList.add(Role.builder().roleName("审计管理员").regTime(regTime).build());
        this.roleRepository.saveAll(roleList);
    }

    @Test
    public void testPage() throws Exception {
        String roleName = null;
        int page = 0;
        int size = 10;
        Pageable rolePageable = PageRequest.of(page, size);
        Page<Role> rolePage = this.roleRepository.findByRoleName(roleName, rolePageable);
        System.out.println("角色信息：" + rolePage.getContent());
    }

}
