package com.qfedu.examination.service;


import com.qfedu.examination.vo.MenuList;

import java.util.List;

public interface MenuInfoService {

    List<MenuList> findMenuInfo(Integer uid);
}
