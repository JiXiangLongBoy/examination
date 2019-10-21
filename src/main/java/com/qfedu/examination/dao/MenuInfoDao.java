package com.qfedu.examination.dao;

import com.qfedu.examination.vo.MenuList;

import java.util.List;

public interface MenuInfoDao {

    //根据用户id查询菜单信息
    public List<MenuList> findMenuInfo(Integer uid);
}
