package com.qfedu.examination.service.impl;


import com.qfedu.examination.dao.MenuInfoDao;
import com.qfedu.examination.service.MenuInfoService;
import com.qfedu.examination.vo.MenuList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    private MenuInfoDao menuInfoDao;

    @Override
    public List<MenuList> findMenuInfo(Integer uid) {
        return menuInfoDao.findMenuInfo(uid);
    }
}
