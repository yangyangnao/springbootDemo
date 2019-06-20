package com.chenbing.base.service;

import com.chenbing.base.dao.UserDao;
import com.chenbing.base.entity.AccountEntity;
import com.chenbing.base.param.UserListReqParam;
import com.chenbing.utils.PageModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public PageModel<AccountEntity> getList(UserListReqParam reqParam){
        PageHelper.startPage(reqParam.getPage(), reqParam.getRows());
        List<AccountEntity> ls = userDao.getList(reqParam);
        PageInfo<AccountEntity> pageInfo = new PageInfo<>(ls);
        PageModel<AccountEntity> pageModel = new PageModel<>(pageInfo);
        return pageModel;
    }
}
