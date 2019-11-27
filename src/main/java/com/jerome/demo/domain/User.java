package com.jerome.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String userName;
    
    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false)
    private Boolean sex;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = true, unique = true)
    private String nickName;
    
    @Column(nullable = false)
    private String regTime;

    @Column(nullable = true)
    private Date loginTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumUserType userType;

    @Transient
    private List<Role> roleList;

}
