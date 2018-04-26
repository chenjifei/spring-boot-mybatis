package com.cf.dao;

import com.cf.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserDao {
    List<User> findAllUser();
}
