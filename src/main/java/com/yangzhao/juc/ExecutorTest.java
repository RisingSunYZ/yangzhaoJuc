package com.yangzhao.juc;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/14 17:30
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */



/**
 当等待队列满时，且达到最大线程数，再有新任务到来，就需要启动拒绝策略。JDK提供了四种拒绝策略，分别是。

 AbortPolicy：默认的策略，直接抛出RejectedExecutionException异常，阻止系统正常运行。
 CallerRunsPolicy：既不会抛出异常，也不会终止任务，而是将任务返回给调用者。
 DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再次提交任务。
 DiscardPolicy：直接丢弃任务，不做任何处理。
 **/


/**
 线程池创建的七个参数
 参数	意义
 corePoolSize	线程池常驻核心线程数
 maximumPoolSize	能够容纳的最大线程数
 keepAliveTime	空闲线程存活时间
 unit	存活时间单位
 workQueue	存放提交但未执行任务的队列
 threadFactory	创建线程的工厂类
 handler	等待队列满后的拒绝策略
 **/


/**
 自定义线程池参数选择
 对于CPU密集型任务，最大线程数是CPU线程数+1。对于IO密集型任务，尽量多配点，可以是CPU线程数*2，或者CPU线程数/(1-阻塞系数)。 (阻塞系数在0.8-0.9之间)
 **/
public class ExecutorTest {

    public static void main(String[] args) throws Exception{
//        testExecutorFix();
//        testExecutorSingle();
//        testCacheExecutor();
        testThreadPoolExecutor();
    }


    static void testThreadPoolExecutor(){

        int j = Runtime.getRuntime().availableProcessors();
//        System.out.println(i);
//        ThreadPoolExecutor ThreadPoolExecutor = new ThreadPoolExecutor(2,5,3, TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
//            Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

//                ThreadPoolExecutor ThreadPoolExecutor = new ThreadPoolExecutor(2,5,3, TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
//            Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());

//        ThreadPoolExecutor ThreadPoolExecutor = new ThreadPoolExecutor(2,5,3, TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
//                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());

        ThreadPoolExecutor ThreadPoolExecutor = new ThreadPoolExecutor(2,5,3, TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());


        try{
            // 最大 请求数不能超过 阻塞队列+maxPoolSize
            for(int i=0;i<9;i++){
                ThreadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"===>");
                });

//                TimeUnit.MILLISECONDS.sleep(500);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ThreadPoolExecutor.shutdown();
        }






    }


    static void testCacheExecutor(){
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0;i<1;i++){
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName()+"===>");
            });
        }

    }


    static void testExecutorSingle() throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i=0;i<5;i++){
            String s = executorService.submit(()->{
                UUID uuid = UUID.randomUUID();
                return uuid.toString();
            }).get();


            System.out.println(Thread.currentThread().getName()+"===>"+s);

        }


    }


    static void testExecutorFix(){
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        for(int i=0;i<50;i++){
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"正在执行任务");
            });
        }


    }
}
