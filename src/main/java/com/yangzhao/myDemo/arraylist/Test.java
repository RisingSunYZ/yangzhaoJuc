package com.yangzhao.myDemo.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/30 15:24
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * 扩容机制
 *
 * 先去看elemenData是不是空集合
 * 是的话去看size 和 10 谁大，谁大谁去做 最小扩容了量
 * 不是 取 size+1 作为最小扩容量
 *
 * 扩容：
 * int temp = elementa * 1.5 大于  最小扩容量？ lementa * 1.5 ： 最小扩容量
 * Arrays.copy （elementa，temp）
 *
 */
public class Test {

    public static void main(String[] args) throws Exception{
//        testArraysCopy();
//        testSystemCopy();
        testYzArrayList();
    }

    private static void testYzArrayList() throws Exception{

        YzArrayList<String> yzArrayList = new YzArrayList(3);
        yzArrayList.add("a");
        yzArrayList.add("c");
        yzArrayList.add("d");
        yzArrayList.add("e");



        for(int i=0;i<yzArrayList.size();i++){
            System.out.println(yzArrayList.get(i));
        }

    }

    static void testSystemCopy(){


        ArrayList<Object> objects = new ArrayList<>();
        objects.remove(1);
        int arr[] = {1,2,3,4,5};
        System.arraycopy(arr,0,arr,2,2);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    static void testArraysCopy(){
        int arr[] = {1,2,3,4,5};
        int[] ints = Arrays.copyOf(arr, 3);
        for(int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }
}
