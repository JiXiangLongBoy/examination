package com.qfedu.examination.vo;


import com.qfedu.examination.entity.Cmenu;
import lombok.Data;

import java.util.List;

@Data
public class MenuList {

    private String pname;
    private List<Cmenu> cmenu;
}
