package com.qfedu.examination.entity;

import lombok.Data;

@Data
public class Permission {

    private Integer pid;
    private String pname;
    private String pdesc;
    private Integer type;
    private String url;
    private Integer parentId;
}
