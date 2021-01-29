package com.yushu.study.dao;


import com.yushu.study.bean.User;
import com.yushu.study.util.base.Page;

public interface UserDao {

	int insert(User roncooUser);

	int deleteById(int id);

	int updateById(User roncooUser);

	User selectById(int id);

	Page<User> queryForPage(int i, int j, String string);

}
