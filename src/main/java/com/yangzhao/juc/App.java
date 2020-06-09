package com.yangzhao.juc;

import com.yangzhao.designPattern.single.EnumSingle;

import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {

//        MyThread MyThread = new MyThread();
//        MyThread.start();



//        MyThread2 MyThread2 = new MyThread2();
//        Thread Thread = new Thread(MyThread2);
//        Thread.start();


//        new Thread(()->{
//            System.out.println("lamada");
//            System.out.println(Thread.currentThread().getName());
//        },"yangzhapo").start();

//        System.out.println( "Hello World!" );
//
//        for(int i=0;i<1000;i++){
//            new Thread(()->{
//                LazySingle single = LazySingle.getSingle();
//            },i+"").start();
//        }

//        for(int i=0;i<1000;i++){
//            new Thread(()->{
//                HungrySingle single = HungrySingle.getSingle();
//            },i+"").start();
//        }

                for(int i=0;i<1000;i++){
            new Thread(()->{
                EnumSingle single = EnumSingle.getSingle();
                System.out.println(single.getStu());
            },i+"").start();
        }


//        FutureTask<String> task = new FutureTask<>(new MyThread3());
//        Thread thread3 = new Thread(task);
//        thread3.start();
//
//        System.out.println(task.get());//最好将FutureTask的get操作放在最后，因为get操作会阻塞其他线程
//
//        System.out.println("=================1===================");




    }
}
