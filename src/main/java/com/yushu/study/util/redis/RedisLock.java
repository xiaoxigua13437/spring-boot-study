package com.yushu.study.util.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * redis实现分布式锁
 *
 * @author yushu.zhao
 * @create 2021-04-29 13:42
 */
@Component
public class RedisLock {

    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key
     * @param value 当前时间 + 超时时间
     * @return
     */
    public boolean lock(String key, String value){
        if (redisTemplate.opsForValue().setIfAbsent(key, value)){
            return true;
        }

        //解决死锁，且当多个线程同时来时，只会让一个线程拿到锁
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果过期
        if (!StringUtils.isEmpty(currentValue) &&
                Long.parseLong(currentValue) < System.currentTimeMillis()){
            //获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }

        return false;
    }


    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value){

        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            logger.error("【redis锁】解锁失败, {}", e);
        }
    }


}
