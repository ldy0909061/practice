package cc.ldy.practice.producerconsumer.v1;


/**
 * Created by ldy on 2017/12/15.
 */
public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Queue q = new Queue();

        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);



        producer.start();
        consumer.start();

        producer.join();
        consumer.join();


    }
}
