package com.fzy.learn.cache.impl;

import com.fzy.learn.bean.UserLog;
import com.fzy.learn.cache.UserLogCache;
import com.fzy.learn.dao.UserLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Repository;

// 开启缓存，需要显示的指定
@EnableCaching
@CacheConfig(cacheNames = "userLogCache")
@Repository
public class UserLogCacheImpl implements UserLogCache {

	@Autowired
	private UserLogDao userLogDao;

	@Cacheable(key = "#p0")
	@Override
	public UserLog selectById(Integer id) {
		System.out.println("查询功能，缓存找不到，直接读库, id=" + id);
		return userLogDao.findOne(id);
	}

	@CachePut(key = "#p0")
	@Override
	public UserLog updateById(UserLog userLog) {
		System.out.println("更新功能，更新缓存，直接写库, id=" + userLog);
		return userLogDao.save(userLog);
	}

	@CacheEvict(key = "#p0")
	@Override
	public String deleteById(Integer id) {
		System.out.println("删除功能，删除缓存，直接写库, id=" + id);
		return "清空缓存成功";
	}

}
