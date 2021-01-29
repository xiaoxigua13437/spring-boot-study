package com.yushu.study.dao.mybatis;

import com.yushu.study.bean.User;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserXmlMapper {

	List<User> select();
}
