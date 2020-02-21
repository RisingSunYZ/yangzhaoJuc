package com.yangzhao.jvm;

import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/20 11:45
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class WeakHashMapDemo {

    public static void main(String[] args) throws Exception{

        weakhashMap();
//        hashMap();
    }

    private static void weakhashMap() throws Exception{

        WeakHashMap<String, String> map = new WeakHashMap<>();
        String key = new String("1");//用new 就可以。。。。。 String key = "1" 不行
        String value = "WeakHashMap";
        map.put(key, value);
        System.out.println(map);
        key = null;
//        System.gc();


        try{
            byte[] arr = new byte[15*1024*1024];


        }catch (Exception e){

        }finally {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(map);

            System.out.println(map + "\t" + map.size());
        }







    }

    private static void hashMap() {

        HashMap<Integer, String> map = new HashMap<>();
        Integer key = 1;
        String value = "HashMap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);


        try{
            byte[] arr = new byte[15*1024*1024];
            System.gc();
        }catch (Exception e){

        }finally {
            System.out.println(map);
            System.out.println("\t" + map.size());
        }



    }
}
