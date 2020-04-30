package com.yangzhao.designPattern.proxy.dymicProxyjdk;

import com.yangzhao.designPattern.proxy.staticproxy.AnimalManagerImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/11 16:47
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * JDK代理是不需要第三方库支持，只需要JDK环境就可以进行代理，使用条件:
 *
 * 1）实现InvocationHandler 
 *
 * 2）使用Proxy.newProxyInstance产生代理对象
 *
 * 3）被代理的对象必须要实现接口
 *
 * CGLib必须依赖于CGLib的类库，但是它需要类来实现任何接口代理的是指定的类生成一个子类，
 *
 * 覆盖其中的方法，是一种继承但是针对接口编程的环境下推荐使用JDK的代理
 */
public class TestCglibProxy {
    public static void main(String[] args) {

//        UserManagerImpl UserManagerImpl = new UserManagerImpl();
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(UserManagerImpl.getClass());
//        enhancer.setCallback(new CglibProxy(UserManagerImpl));
//        UserManagerImpl o = (UserManagerImpl)enhancer.create();
//        o.add();

        AnimalManagerImpl AnimalManagerImpl = new AnimalManagerImpl();
        CglibProxy CglibProxy2 = new CglibProxy(AnimalManagerImpl);

        Enhancer Enhancer2 = new Enhancer();
        Enhancer2.setSuperclass(AnimalManagerImpl.getClass());
        Enhancer2.setCallback(CglibProxy2);
        AnimalManagerImpl o1 = (AnimalManagerImpl)Enhancer2.create();
        String zczxc = o1.sayHellow("zczxc");
        System.out.println(zczxc);

    }
}
