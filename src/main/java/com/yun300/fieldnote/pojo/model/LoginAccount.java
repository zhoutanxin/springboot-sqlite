package com.yun300.fieldnote.pojo.model;

import lombok.Data;

@Data
public class LoginAccount {
    private Long id;
    private String account;
    private String password;
    private String oriPassword;
    private String email;
    private String phone;
    private Integer loginType;
    private Integer status;
    private String created;
    private String modified;
}
