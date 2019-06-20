package com.chenbing.base.dao;

import com.chenbing.base.entity.AccountEntity;
import com.chenbing.base.param.UserListReqParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<AccountEntity> getList(UserListReqParam reqParam);
}
