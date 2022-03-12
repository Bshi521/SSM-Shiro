package com.aiit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  Integer id;
    private String loginname;
    private String password;
    private String username;
//    第二次作业 盐值
    private String salt;
    private Integer status;
}
