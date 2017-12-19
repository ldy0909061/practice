package cc.ldy.practice.dynamicproxy;

/**
 * Created by ldy on 2017/12/19.
 */
public class UserEntity implements User{
    public void printName() {
        System.out.println("I am user");
    }

    public void printAge() {
        System.out.println("10");
    }
}
