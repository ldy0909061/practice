package cc.ldy.practice.producerconsumer;

/**
 * Created by ldy on 2017/12/15.
 */
public interface IQueue {
    void write(int obj);
    int read();
}
