package com.yun300.fieldnote.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class LoginVO {
    @ApiModelProperty(value = "登录账号", required = true)
    @NotEmpty
    private String account;
    @ApiModelProperty(value = "登录密码", required = false)
    private String password;
    @ApiModelProperty(value = "验证码", required = false)
    private String captcha;
}
