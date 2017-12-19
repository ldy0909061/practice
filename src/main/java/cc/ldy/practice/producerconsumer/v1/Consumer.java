package cc.ldy.practice.producerconsumer.v1;

import cc.ldy.practice.producerconsumer.IQueue;

/**
 * Created by ldy on 2017/12/15.
 */
public class Consumer extends Thread{
    private IQueue queue;

    public Consumer(IQueue queue) {
        this.queue = queue;
    }

    public void run() {
        if (queue == null) {
            throw new RuntimeException("null queue");
        }

        int i = 0;
        while (i++ < 100) {
            queue.read();
        }
    }

}
