package com.jerome.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRelationRepository extends JpaRepository<UserRoleRelation, Long> {

    @Query(value = "select r2 from UserRoleRelation r left join " +
            "Role r2 on r.roleId = r2.id  where r.userId = ?1")
    List<Role> getRoleByUserId(long userId);

}
