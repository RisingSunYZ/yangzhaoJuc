package com.yangzhao.juc;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/13 9:47
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class ThreadLocalTest {



    public static void main(String[] args) throws Exception{
        test();
    }

    static void test() throws Exception{
        ThreadLocal<Integer> myLocal = new ThreadLocal<>();


//        ThreadLocal<Integer> myLocal = new ThreadLocal.SuppliedThreadLocal(()->1);
        /**
         *    static final class SuppliedThreadLocal<T> extends ThreadLocal<T> {
         *
         *         private final Supplier<? extends T> supplier;
         *
         *         SuppliedThreadLocal(Supplier<? extends T> supplier) {
         *             this.supplier = Objects.requireNonNull(supplier);
         *         }
         *
         *         @Override
         *         protected T initialValue() {
         *             return supplier.get();
         *         }
         *     }
         **/





        /**
         * @Author YangZhao
         * @Description 每个线程维护了一个  ThreadLocalMap，ThreadLocalMap的key就是相同的ThreadLocal实例，value就是我们传入的值
         * @Date 10:30 2020/1/13
         * @Param []
         * @return void
         **/

        new Thread(()->{
          try{
              myLocal.set(1);
              System.out.println(Thread.currentThread().getName()+myLocal.get());
          }catch (Exception e){
              e.printStackTrace();
          }finally {
              //必须回收 否则会有内存泄露，因为存在弱引用
              myLocal.remove();
          }
        },"AA").start();



        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+myLocal.get());
        },"BB").start();

    }
}
