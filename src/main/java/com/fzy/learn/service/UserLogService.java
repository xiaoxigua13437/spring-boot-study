package com.fzy.learn.service;

import com.fzy.learn.bean.User;
import com.fzy.learn.bean.UserLog;
import com.fzy.learn.dao.UserLogDao;
import java.util.ArrayList;
import java.util.List;
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

  public List<UserLog> findByIds(List<Integer> ids){
    if (ids==null || ids.size()==0){
      return new ArrayList<>();
    }
    return userLogDao.findByIds(ids);
  }

}
