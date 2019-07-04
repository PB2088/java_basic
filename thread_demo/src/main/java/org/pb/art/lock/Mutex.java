package org.pb.art.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author boge.peng
 * @create 2019-05-12 23:58
 */
public class Mutex implements Lock {

    /**
     * 定义静态内部类,自定义同步器
     */
    private static class Sync extends AbstractQueuedSynchronizer {
        /**
         * 是否处于占用状态
         * @return
         */
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 当状态为0的时候获取锁
         * @param arg
         * @return
         */
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0,1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }

            return false;
        }

        /**
         * 释放锁,将状态设置为0
         * @param arg
         * @return
         */
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw  new IllegalMonitorStateException();
            }

            setExclusiveOwnerThread(null);
            setState(0);

            return true;
        }

        /**
         * 返回一个Condition,每个condition都包含了一个Condition队列
         * @return
         */
        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    private final  Sync sync = new Sync();

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
