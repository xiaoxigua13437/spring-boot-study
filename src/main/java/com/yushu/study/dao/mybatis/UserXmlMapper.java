package com.yushu.learn.dao.mybatis;

import com.yushu.learn.bean.User;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserXmlMapper {

	List<User> select();
}
