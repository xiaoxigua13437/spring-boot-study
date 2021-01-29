package com.yushu.study.dao;

import com.yushu.study.bean.UserLog;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserLogDao extends JpaRepository<UserLog, Integer> {

	@Query(value="select u from UserLog u where u.name=?1")
	UserLog findByName(String string);

	UserLog findByNameAndIp(String string, String ip);

	Page<UserLog> findByName(String string, Pageable pageable);

	@Query(value = "select  u from UserLog u where u.id in ?1 ")
	List<UserLog> findByIds(List<Integer> ids);
}
