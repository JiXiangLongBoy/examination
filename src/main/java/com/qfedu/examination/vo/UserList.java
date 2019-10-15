package com.qfedu.examination.vo;

import com.qfedu.examination.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserList {

    private Integer uid;
    private String username;
    private String password;
    private List<Role> role;
    private String rdesc;
}
