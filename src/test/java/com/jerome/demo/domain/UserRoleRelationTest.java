package com.jerome.demo.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRoleRelationTest {

    @Autowired
    private UserRoleRelationRepository relationRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        this.userRepository.deleteAll();
        this.roleRepository.deleteAll();
        this.relationRepository.deleteAll();

        Date regTime = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(regTime);

        List<User> userList = new ArrayList<User>(3);
        userList.add(User.builder().userName("aa1").passWord("123456").nickName("张三").sex(true).email("aa@126.com")
                .regTime(formattedDate).userType(EnumUserType.Register).build());
        userList.add(User.builder().userName("bb2").passWord("123456").nickName("李四").sex(true).email("bb@126.com")
                .regTime(formattedDate).userType(EnumUserType.Register).build());
        userList.add(User.builder().userName("cc3").passWord("123456").nickName("王五").sex(true).email("cc@126.com")
                .regTime(formattedDate).userType(EnumUserType.Register).build());
        userList = this.userRepository.saveAll(userList);

        List<Role> roleList = new ArrayList<Role>(3);
        roleList.add(Role.builder().roleName("系统管理员").regTime(regTime).build());
        roleList.add(Role.builder().roleName("用户管理员").regTime(regTime).build());
        roleList.add(Role.builder().roleName("审计管理员").regTime(regTime).build());
        roleList = this.roleRepository.saveAll(roleList);

        long userAId = userList.get(0).getId();
        long userBId = userList.get(1).getId();
        long userCId = userList.get(2).getId();
        long sysRoleId = roleList.get(0).getId();
        long userRoleId = roleList.get(1).getId();
        long auditRoleId = roleList.get(2).getId();

        List<UserRoleRelation> relationList = new ArrayList<UserRoleRelation>(6);
        relationList.add(UserRoleRelation.builder().userId(userAId).roleId(sysRoleId).build());
        relationList.add(UserRoleRelation.builder().userId(userAId).roleId(userRoleId).build());
        relationList.add(UserRoleRelation.builder().userId(userAId).roleId(auditRoleId).build());
        relationList.add(UserRoleRelation.builder().userId(userBId).roleId(userRoleId).build());
        relationList.add(UserRoleRelation.builder().userId(userCId).roleId(auditRoleId).build());
        this.relationRepository.saveAll(relationList);

        List<Role> userARoleList = this.relationRepository.getRoleByUserId(userAId);
        System.out.println("用户[" + userAId + "]的角色信息：" + userARoleList);
    }

}
