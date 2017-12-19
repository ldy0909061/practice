package cc.ldy.practice.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by ldy on 2017/12/19.
 */
public class UserInvocationHandler implements InvocationHandler{
    private User user;

    public UserInvocationHandler(User user) {
        this.user = user;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //do something "dynamic"
        if (method.getName().equals("printName")) {
            System.out.println("I am proxy user!");
            System.out.println(proxy.getClass().getSimpleName());
            return method.invoke(user, args);
        }
        return method.invoke(user, args);
    }
}
