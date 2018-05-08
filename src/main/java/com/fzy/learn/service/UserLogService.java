package com.fzy.learn.service;

import com.fzy.learn.bean.User;
import com.fzy.learn.bean.UserLog;
import com.fzy.learn.dao.UserLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fuzhongyu
 * @date 2018/3/21
 */
@Service
public class UserLogService {

  @Autowired
  private UserLogDao userLogDao;

  @Transactional
  public UserLog insert(UserLog userLog){
    
    return userLogDao.saveAndFlush(userLog);
  }

  public UserLog get(Integer id){
    return userLogDao.findOne(id);
  }

}
