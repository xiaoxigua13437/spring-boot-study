package com.fzy.learn.dao;

import com.fzy.learn.bean.UserLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserLogMongoDao extends MongoRepository<UserLog, Integer>{

	UserLog findByName(String string);

	UserLog findByNameAndIp(String name, String ip);

	Page<UserLog> findByName(String string, Pageable pageable);
}
