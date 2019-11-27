package com.jerome.demo.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void testSaveUser() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(date);
        User a = User.builder().userName("aa1").passWord("123456").nickName("张三").sex(true).email("aa@126.com").regTime(formattedDate).userType(EnumUserType.Register).build();
        User b = User.builder().userName("bb2").passWord("123456").nickName("李四").sex(true).email("bb@126.com").regTime(formattedDate).userType(EnumUserType.Register).build();
        User c = User.builder().userName("cc3").passWord("123456").nickName("王五").sex(true).email("cc@126.com").regTime(formattedDate).userType(EnumUserType.Register).build();
        this.userRepository.deleteByUserName(a.getUserName());
        this.userRepository.deleteByUserName(b.getUserName());
        this.userRepository.deleteByUserName(c.getUserName());
        this.userRepository.save(a);
        this.userRepository.save(b);
        this.userRepository.save(c);
        Assert.assertEquals(3, userRepository.count());
    }
    
    @Test
    public void testFindByUserName() throws Exception {
    	User user = this.userRepository.findByUserName("aa1");
        Assert.assertEquals("aa1", user.getUserName());
    }

    @Test
    public void testBaseQuery() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:SS");
        User user = User.builder()
                .userName("dengjw")
                .passWord("123456")
                .nickName("孤独的天163")
                .sex(true)
                .email("452437621@163.com）")
                .regTime(format.format(new Date()))
                .userType(EnumUserType.Register)
                .build();
        System.out.println("保存前：" + user);
        this.userRepository.deleteByUserName(user.getUserName());
        this.userRepository.save(user);
        System.out.println("保存后：" + user);

        List<User> all = this.userRepository.findAll();
        User user1 = this.userRepository.getOne(1L);
        Long count = this.userRepository.count();
        boolean exists = this.userRepository.existsById(1L);
    }
    
    @Test
    public void testUserPage() throws Exception {
        int page = 0;
        int size = 10;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> pageObj = this.userRepository.findAllBy(pageable);
        List<User> userList = pageObj.getContent();
        System.out.println("userList = " + userList);

        List<String> userNameList = pageObj.stream().map(user -> { return user.getUserName();})
                .collect(Collectors.toList());
        System.out.println(userNameList);
    }

    @Test
    public void testGetFirst() throws Exception {
        User firstRegUser = this.userRepository.findFirstByOrderByRegTimeAsc();
        System.out.println("最早注册的用户：" + firstRegUser);
    }
}
