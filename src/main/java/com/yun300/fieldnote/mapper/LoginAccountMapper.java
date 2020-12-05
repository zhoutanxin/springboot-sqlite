package com.yun300.fieldnote.mapper;

import com.yun300.fieldnote.pojo.model.LoginAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoginAccountMapper {
    //注册账号
    @Insert("INSERT INTO sys_login_account(id,account, password,ori_password,email,phone," +
            "login_type,status,created,modified) " +
            "VALUES(#{id},#{account}, #{password}, #{oriPassword},#{email},#{phone}," +
            "#{loginType},#{status},#{created},#{modified})")
//    @SelectKey(statement = "SELECT seq id FROM sqlite_sequence WHERE (name = 'sys_login_account')", before = false, keyProperty = "id", resultType = int.class)
    int insert(LoginAccount loginAccount);

    // 根据手机号查询
    @Select("SELECT * FROM sys_login_account WHERE phone=#{phone}")
    LoginAccount selectByPhone(String phone);

    //修改密码
    @Update("UPDATE sys_login_account SET password=#{password} WHERE id=#{id}")
    int updatePasswd(LoginAccount loginAccount);

    // 根据 ID 删除
    @Delete("DELETE FROM sys_login_account WHERE id=#{id}")
    int delete(Integer id);
}
