package com.fzy.learn.dao;


import com.fzy.learn.bean.User;
import com.fzy.learn.util.base.Page;

public interface UserDao {

	int insert(User roncooUser);

	int deleteById(int id);

	int updateById(User roncooUser);

	User selectById(int id);

	Page<User> queryForPage(int i, int j, String string);

}
