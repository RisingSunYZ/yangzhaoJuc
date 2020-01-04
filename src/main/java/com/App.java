package com;

import com.yangzhao.juc.LazySingle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        MyThread MyThread = new MyThread();
//        MyThread.start();



//        MyThread2 MyThread2 = new MyThread2();
//        Thread Thread = new Thread(MyThread2);
//        Thread.start();


//        new Thread(()->{
//            System.out.println("lamada");
//            System.out.println(Thread.currentThread().getName());
//        },"yangzhapo").start();

        System.out.println( "Hello World!" );

        for(int i=0;i<1000;i++){
            new Thread(()->{
                LazySingle single = LazySingle.getSingle();
            },i+"").start();
        }

//        for(int i=0;i<1000;i++){
//            new Thread(()->{
//                HungrySingle single = HungrySingle.getSingle();
//            },i+"").start();
//        }





    }
}
