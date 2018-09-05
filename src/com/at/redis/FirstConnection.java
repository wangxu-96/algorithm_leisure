package com.at.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class FirstConnection {
    public static void main(String[] args){
        Jedis jedis=RedisTool.getConnection("127.0.0.1","wangxu960722");
        RedisTool.tryGetDistributedLock(jedis,"123", UUID.randomUUID().toString(),100000);
    }
}
