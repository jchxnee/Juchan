package com.kh.boot.domain.vo;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Member {
    private String userId;
    private String userPwd;
    private String userName;
    private String email;
    private String gender;
    private int age;
    private String phone;
    private String address;
    private Date enrollDate;
    private String modifyDate;
    private String status;

}