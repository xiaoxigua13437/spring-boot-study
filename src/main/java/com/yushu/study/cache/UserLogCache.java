package com.yushu.learn.cache;


import com.yushu.learn.bean.UserLog;

public interface UserLogCache {

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	UserLog selectById(Integer id);

	/**
	 * 更新
	 * 
	 * @param userLog
	 * @return
	 */
	UserLog updateById(UserLog userLog);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	String deleteById(Integer id);
}
