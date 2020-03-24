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


/**
 * @Author YangZhao
 * @Description
 * @Date 15:12 2020/3/24
 * @Param
 * @return
 *
 * 线程池异常处理
 *
 * execute 无返回结果 会自动抛出异常   1. 可以通过 try catch 2.setUncaughtExceptionHandler
 * submit 有返回结果  不会自动抛出异常 1.可以通过 try catch 2. future.get() 3
 *
 **/
public class ExecutorTest {

    public static void main(String[] args){
//        testExecutorFix();
//        testExecutorSingle();
//        testCacheExecutor();
//        testThreadPoolExecutor();
        testException();


    }

    private static void testException() {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 5; i++) {
//            threadPool.execute(() -> {
//              try{
//                  System.out.println("current thread name" + Thread.currentThread().getName());
//                  Object object = null;
//                  System.out.print("result## " + object.toString());
//              }catch (Exception e){
//                  e.printStackTrace();
//              }
//            });
//        }


//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 5; i++) {
//            Future<?> submit = threadPool.submit(() -> {
//                System.out.println("current thread name" + Thread.currentThread().getName());
//                Object object = null;
//                System.out.print("result## " + object.toString());
//
//            });
//
//            try{
//                Object o = submit.get();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }



//        ExecutorService threadPool2 = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 5; i++) {
//            threadPool2.execute(() -> {
//                try{
//                    System.out.println("current thread name" + Thread.currentThread().getName());
//                    Object object = null;
//                    System.out.print("result## "+object.toString());
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            });
//        }



//        ExecutorService threadPool3 = Executors.newFixedThreadPool(5,(r)->{
//            Thread t = new Thread(r);
//            t.setUncaughtExceptionHandler((t1,e)->{
//                System.out.println(t1.getName()+"发生异常"+e.getMessage());
//            });
//            return t;
//        });
//        for (int i = 0; i < 5; i++) {
//            threadPool3.execute(() -> {
//                System.out.println("current thread name" + Thread.currentThread().getName());
//                Object object = null;
//                System.out.print("result## "+object.toString());
//            });
//        }


        ExtendExecutor extendExecutor = new ExtendExecutor(2, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());


        for(int i=0;i<5;i++){
            extendExecutor.submit(()->{
                Object a = null;
                System.out.println(a.toString());
            });

        }

        extendExecutor.shutdown();




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

class ExtendExecutor extends ThreadPoolExecutor{


    public ExtendExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public ExtendExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public ExtendExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public ExtendExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void terminated() {
        super.terminated();
        System.out.println(Thread.currentThread().getName()+"线程关闭");
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println(Thread.currentThread().getName()+"线程执行之前调用");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        System.out.println(Thread.currentThread().getName()+ "线程执行之后调用");
        if(null ==t && r instanceof Future<?>){

            try{
                Object o = ((Future<?>) r).get();
            }catch (Exception e){
                t = e;
            }
        }

        if(null != t){
            System.out.println("afterExecute============");
            System.out.println(t.getMessage());
            System.out.println(t.getStackTrace());
        }


    }
}
