package com.at.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class FirstConnection {
    public static void main(String[] args){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("47.94.242.46");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        Set<String> redisKeys=jedis.keys("*");
        Iterator iterator=redisKeys.iterator();
        while (iterator.hasNext()){
            String s=(String) iterator.next();
            System.out.println("redis key---"+s+"value----"+jedis.get(s));
        }
        //System.out.println(null instanceof String);
    }
}
