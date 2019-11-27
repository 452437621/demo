package com.jerome.demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // 对象查询
    User findByUserName(String userName);

    User findByUserNameAndPassWord(String userName, String password);

    User findFirstByOrderByRegTimeAsc();

    // 列表查询
    List<User> findByRegTime(String time);

    List<User> findByUserNameIgnoreCase(String userName);

    // 统计查询
    Long countBy();

    // 分页查询
    Page<User> findByUserNameAndSex(String userName, boolean sex, Pageable pageable);

    Page<User> findAllBy(Pageable pageable);

    // 删除
    void deleteByUserName(String userName);
}
