package com.yangzhao.java8.innerclass;

/**
 * @Description:
 * @Author:YangZhao 内部类实现多继承
 * @Since:2020/6/15 17:41
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class FlyAndRun {

   private  class InnerFly extends Fly{
       @Override
       void fly() {
           super.fly();
//           System.out.println("我重写fly");
       }
   }

   private static class InnerRun extends Run{
       @Override
       void run() {
           super.run();
//           System.out.println("我重写run");
       }
   }

   void fly(){
        new InnerFly().fly();
    }

    void run(){
       new InnerRun().run();
    }

}
