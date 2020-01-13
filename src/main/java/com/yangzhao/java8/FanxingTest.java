package com.yangzhao.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/13 10:51
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */


/**
 请记住PECS原则：生产者（Producer）使用extends，消费者（Consumer）使用super。

 生产者使用extends
 如果你需要一个列表提供T类型的元素（即你想从列表中读取T类型的元素），你需要把这个列表声明成<? extends T>，比如List<? extends Integer>，因此你不能往该列表中添加任何元素。

 消费者使用super
 如果需要一个列表使用T类型的元素（即你想把T类型的元素加入到列表中），你需要把这个列表声明成<? super T>，比如List<? super Integer>，因此你不能保证从中读取到的元素的类型。

 即是生产者，也是消费者
 如果一个列表即要生产，又要消费，你不能使用泛型通配符声明列表，比如List<Integer>。
 **/
public class FanxingTest {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        test(apples);

    }

    static void test(List<? extends Fruit> l){
        l.stream().forEach(e->e.call());
    }

}


class Fruit{
    void call(){
        System.out.println("i am fruit");
        System.out.println(this.getClass().getName());
    }

}

class Banana extends Fruit{
    @Override
    void call(){
        System.out.println("i am fruit");
        System.out.println(this.getClass().getName());
    }

}

class Apple extends Fruit{
    @Override
    void call(){
        System.out.println("i am Apple");
        System.out.println(this.getClass().getName());
    }

}
