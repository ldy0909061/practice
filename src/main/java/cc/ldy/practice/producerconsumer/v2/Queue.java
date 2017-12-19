package cc.ldy.practice.producerconsumer.v2;

import cc.ldy.practice.producerconsumer.IQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ldy on 2017/12/15.
 */
public class Queue implements IQueue{
    int [] a = new int[10];
    ReentrantLock lock = new ReentrantLock();
    Condition writeCondition = lock.newCondition();
    Condition readCondition = lock.newCondition();

    private int count;//当前队列中的元素数
    private int writeIdx;
    private int readIdx;

    public void write(int obj) {
        lock.lock();
        try {
            while (count >= a.length) {
                try {
                    writeCondition.await();
                } catch (InterruptedException e) {

                }
            }

            if (writeIdx == a.length) {
                writeIdx = 0;
            }

            a[writeIdx] = obj;
            count++;
            writeIdx++;
            System.out.println("write count:"+count);
            System.out.println("write:"+obj);
            readCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int read() {
        lock.lock();
        int ret;
        try {
            while (count <= 0) {
                try {
                    readCondition.await();
                } catch (InterruptedException e) {

                }
            }
            if (readIdx >= a.length) {
                readIdx = 0;
            }

            ret = a[readIdx];
            readIdx++;
            count--;
            System.out.println("read count:"+count);
            System.out.println("read:"+ret);
            writeCondition.signalAll();
        } finally {
            lock.unlock();
        }

        return ret;
    }
}
