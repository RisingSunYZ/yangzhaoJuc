package com.yangzhao.juc;

/**
 * @Description: 单例模式 双重检索
 * @Author:YangZhao
 * @Since:2020/1/4 15:48
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class LazySingle {

    private static volatile LazySingle lazySingle = null;//禁止指令重排,创建对象会有多步

    private LazySingle(){

    }

    public static  LazySingle getSingle(){ //synchronized 加在方法上，浪费资源 锁等待
        if(null == lazySingle){ //处理锁等待
            synchronized(LazySingle.class){
                if(null == lazySingle){ //不加这个 多个线程进来会创建多个
                    lazySingle = new LazySingle();
//                    memory = allocate(); //1.分配内存
//                    instance(memory);	 //2.初始化对象
//                    instance = memory;	 //3.设置引用地址
//                    其中2、3没有数据依赖关系，可能发生重排。如果发生，此时内存已经分配，
//                    那么instance=memory不为null。如果此时线程挂起，instance(memory)还未执行，
//                    对象还未初始化。由于instance!=null，所以两次判断都跳过，最后返回的instance没有任何内容，还没初始化。
//                    解决的方法就是对singletondemo对象添加上volatile关键字，禁止指令重排。
                    System.out.println("=======come in===============");
                }
            }
        }
        return lazySingle;
    }
}
