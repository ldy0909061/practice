package cc.ldy.practice.producerconsumer.v1;

import cc.ldy.practice.producerconsumer.IQueue;

/**
 * Created by ldy on 2017/12/15.
 */
public class Queue implements IQueue {
    private int[] a = new int[10];
    private int count;//当前队列中的元素数
    private int writeIdx;
    private int readIdx;

    public void write(int obj) {
        synchronized (this) {
            while (count >= a.length) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }

            if (writeIdx == a.length) {
                writeIdx = 0;
            }

            a[writeIdx] = obj;
            writeIdx++;
            count++;
            System.out.println("write count:"+count);
            System.out.println("write:"+obj);
            print();

            this.notifyAll();

        }
    }

    public int read() {
        synchronized (this) {
            while (count <= 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }

            if (readIdx == a.length) {
                readIdx = 0;
            }

            int ret = a[readIdx];
            readIdx++;
            count--;

            System.out.println("read count:"+count);
            System.out.println("read:"+ret);
            print();
            notifyAll();

            return ret;
        }
    }

    private void print() {
        for (int i :a) {
            System.out.print("" + i + " ");
        }
        System.out.println();
    }
}
