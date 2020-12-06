package com.yun300.fieldnote.controller;

import com.yun300.fieldnote.pojo.model.LoginAccount;
import com.yun300.fieldnote.pojo.vo.LoginDTO;
import com.yun300.fieldnote.service.LoginAccountService;
import com.yun300.fieldnote.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Api(tags={"登录账号管理"})
public class LoginAccountController {
    @Autowired
    LoginAccountService loginAccountService;
    @RequestMapping("/register")
    @ApiOperation(value = "注册账号",httpMethod = "POST")
    public boolean register(LoginAccount model) {
        model.setId(IdWorker.getInstance().nextId());
        model.setCreated(DateUtil.formatDate(new Date()));
        model.setPassword(DigestUtils.md5DigestAsHex(model.getOriPassword().getBytes()));
        model.setModified(DateUtil.formatDate(new Date()));
        return loginAccountService.register(model);
    }
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public JsonResult login(@RequestBody LoginDTO loginVO) {
        LoginAccount userLogin = null;
        if (StringUtils.isEmpty(loginVO.getAccount()) || XssJudgeUtils.isSqlInject(loginVO.getAccount())) {
            return JsonResult.error(ResultCode.ERROR.getMsg());
        }
        userLogin = loginAccountService.findByPhone(loginVO.getAccount());
        // //验证用户名或者手机号
        if (userLogin == null) {
            return JsonResult.error(ResultCode.USER_LOGIN_FAIL.getMsg());
        }
        // 验证密码
        if (!DigestUtils.md5DigestAsHex(loginVO.getPassword().getBytes()).equals(userLogin.getPassword())) {
            return JsonResult.error(ResultCode.USER_LOGIN_FAIL.getMsg());
        }
        return JsonResult.success(ResultCode.SUCCESS.getMsg());
    }
}
