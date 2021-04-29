package com.yushu.study.service;


import com.yushu.study.util.redis.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 模拟秒杀
 *
 * @author yushu.zhao
 * @create 2021-04-29 13:50
 */
public class SecKillService {

    @Autowired
    private RedisLock redisLock;

    //超时时间10s
    private static final int TIMEOUT = 10 * 1000;


    public void secKill(String productId){
        long time = System.currentTimeMillis() + TIMEOUT;
        //加锁
        if (!redisLock.lock(productId, String.valueOf(time))){
            System.out.println("人太多了，等会儿再试吧~");
            /*throw new SellException(101, "人太多了，等会儿再试吧~");*/
        }

        //具体的秒杀逻辑

        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }


}
