package cc.ldy.practice.producerconsumer.v1;

import cc.ldy.practice.producerconsumer.IQueue;

import java.util.Random;

/**
 * Created by ldy on 2017/12/15.
 */
public class Producer extends Thread {
    private IQueue queue;
    private Random random = new Random();

    public Producer(IQueue queue) {
        this.queue = queue;
    }

    public void run() {
        if (queue == null) {
            throw new RuntimeException("null queue");
        }

        int i = 0;
        while (i++ < 100) {
            queue.write(i);
        }
    }

}
