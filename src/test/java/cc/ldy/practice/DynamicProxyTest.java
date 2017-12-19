package cc.ldy.practice;

import cc.ldy.practice.dynamicproxy.User;
import cc.ldy.practice.dynamicproxy.UserEntity;
import cc.ldy.practice.dynamicproxy.UserInvocationHandler;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by ldy on 2017/12/19.
 */
public class DynamicProxyTest {
    @Test
    public void test() throws Exception {
        InvocationHandler h =  new UserInvocationHandler(new UserEntity());
        User user = (User) Proxy.newProxyInstance(UserEntity.class.getClassLoader(), UserEntity.class.getInterfaces() , h);
        user.printName();
        user.printAge();
    }
}
