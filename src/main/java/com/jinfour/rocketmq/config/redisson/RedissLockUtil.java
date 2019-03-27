package com.jinfour.rocketmq.config.redisson;


import java.util.concurrent.TimeUnit;

public class RedissLockUtil {
    private static DistributedLocker redisLock;

    public static void setLocker(DistributedLocker locker) {
        redisLock = locker;
    }

    public static void lock(String lockKey) {
        redisLock.lock(lockKey);
    }

    public static void unlock(String lockKey) {
        redisLock.unlock(lockKey);
    }

    public static void lock(String lockKey, int timeout, TimeUnit unit) {
        redisLock.lock(lockKey, timeout, unit);
    }

    public static boolean tryLock(String lockKey) {
        return redisLock.tryLock(lockKey);
    }

    public static boolean tryLock(String lockkey, int waitTime, int leaseTime, TimeUnit unit) throws InterruptedException {
        return redisLock.tryLock(lockkey, waitTime, leaseTime, unit);
    }
}
