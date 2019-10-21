package com.qfedu.examination.entity;

import lombok.Data;

import java.util.List;

@Data
public class Permission {

    private Integer pid;
    private String pname;
    private String pdesc;
    private Integer type;
    private String url;
    private Integer parentId;

    private List<Permission> permList;

}
