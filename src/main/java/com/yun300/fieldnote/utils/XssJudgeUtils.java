package com.yun300.fieldnote.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * 字符串防止SQL注入校验
 *
 * @author tangjiawei
 * @date 2019/02/15
 */
public class XssJudgeUtils {
    public static boolean isSqlInject(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        // 统一转为小写
        str = str.toLowerCase();
        String badStr = "'|and|exec|script|execute|insert|select|delete|update|drop|*|%|chr|mid|master|truncate|"
                + "char|declare|sitename|net knowledge|xp_cmdshell|;|or|+|,|like'|and|exec|execute|insert|create|drop|"
                + "table|from|grant|use|group_concat|column_name|"
                + "information_schema.columns|table_schema|union|where|select|delete|update|order|by|*|"
                + "chr|mid|master|truncate|char|declare|or|;|--|+|,|like|//|/|%|#|CR|LF|document|eval|iframe";
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) >= 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0YW5namlhd2VpIiwicGFzc3dvcmQiOiI5NmU3OTIxODk2NWViNzJjOTJhNTQ5ZGQ1YTMzMDExMiIsImlkIjoxOTMzLCJleHAiOjE1NjA4NzQ5NDIsImlhdCI6MTU2MDg2Nzc0MiwianRpIjoiMDZkNDU2ZDYtYWFlMC00YmExLWI2OWEtZTEyNzhlMDQyYTQ4IiwidXNlcm5hbWUiOiJ0YW5namlhd2VpIn0.S4NpRsyBhqmRJSr5TBbdS8VvChRs3fzm9cXVvBNftL";
        System.out.println(isSqlInject(token));
    }

}
