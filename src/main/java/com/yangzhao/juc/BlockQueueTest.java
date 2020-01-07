package com.yangzhao.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/1/7 12:06
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class BlockQueueTest {

    public static void main(String[] args)  throws Exception{
//        testException();
//        testBooelan();
//        testWait();
//        testTimeOut();
        testSynchronousQueue();
    }


    static void testException(){
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.add(1);
        blockingQueue.add(2);
        blockingQueue.add(3);
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

    }

    static void testBooelan(){
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer(1));
        System.out.println(blockingQueue.offer(2));
        System.out.println(blockingQueue.offer(3));
        System.out.println(blockingQueue.offer(3));


//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.peek());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

    }

    static void testWait() throws Exception{
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        new Thread(()->{

            try {
                blockingQueue.put(1);
                blockingQueue.put(2);
                blockingQueue.put(3);
                blockingQueue.put(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(()->{

            try {
                System.out.println(blockingQueue.take());
                System.out.println(blockingQueue.take());
                System.out.println(blockingQueue.take());
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();






    }


    static void testTimeOut() throws Exception{
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);
        new Thread(()->{

            try {
                System.out.println(blockingQueue.offer(1, 1L, TimeUnit.SECONDS));
                System.out.println(blockingQueue.offer(2, 1L, TimeUnit.SECONDS));
                System.out.println(blockingQueue.offer(3, 1L, TimeUnit.SECONDS));
                System.out.println(blockingQueue.offer(4, 1L, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(5);

        new Thread(()->{

            try {
                System.out.println(blockingQueue.poll(1L, TimeUnit.SECONDS));
                System.out.println(blockingQueue.poll(1L, TimeUnit.SECONDS));
                System.out.println(blockingQueue.poll(1L, TimeUnit.SECONDS));
                System.out.println(blockingQueue.poll(1L, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();




    }


    static void testSynchronousQueue() throws Exception{
        BlockingQueue<Integer> blockingQueue = new SynchronousQueue<>();
        new Thread(()->{

            try {
                for(int i=1;i<=5;i++){
                    System.out.println(System.currentTimeMillis());
                    blockingQueue.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(()->{

            try {
                for(int i=1;i<=5;i++){
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(blockingQueue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();




    }

}
