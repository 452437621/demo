package com.jerome.demo;

import com.jerome.demo.domain.User;
import com.jerome.demo.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() throws Exception {
        User user1 = User.builder().userName("zhangsan1").password("123456").age(11).email("aaa@163.com").nickName("三三").phoneNumber("暂无").regTime(null).build();
        this.userRepository.save(user1);
    }

}
