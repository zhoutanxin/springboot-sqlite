package com.yun300.fieldnote.service;

import com.yun300.fieldnote.mapper.LoginAccountMapper;
import com.yun300.fieldnote.pojo.model.LoginAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAccountService {
    @Autowired
    private LoginAccountMapper loginAccountDAO;

    public boolean register(LoginAccount model) {
        return loginAccountDAO.insert(model) > 0;
    }

    public LoginAccount findByPhone(String phone) {
        return loginAccountDAO.selectByPhone(phone);
    }
}
