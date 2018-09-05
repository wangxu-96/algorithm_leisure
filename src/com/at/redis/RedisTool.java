package com.at.redis;

import redis.clients.jedis.Jedis;

public class RedisTool {
    private static final String LOCK_SUCCESS="OK";
    private static final String SET_IF_NOT_EXIST="NX";
    private static final String SET_WITH_EXPIRE_TIME="PX";
    private static Jedis jedis=null;
    /**
     * 尝试获取分布式锁
     * @param jedis jedis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis,String lockKey,String requestId,int expireTime){
        String result=jedis.set(lockKey,requestId,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,expireTime);
        if (LOCK_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

    /**
     * 获取jedis连接
     * @param ip
     * @param password
     * @return
     */
    public static Jedis getConnection(String ip,String password){
        if (jedis==null){
            jedis = new Jedis("127.0.0.1");
            jedis.auth("wangxu960722");
        }
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        return jedis;
    }
}
