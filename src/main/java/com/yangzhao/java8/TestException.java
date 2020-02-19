package com.yangzhao.java8;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/19 13:17
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TestException {

    public static void main(String[] args) {

//        String a = "123";
//
//        try{
//            System.out.println("try==>"+a);
//            int b = 1/0;
//        }catch (Exception e){
//            e.printStackTrace();
//            throw e;
//        }finally {
//            System.out.println("finally==>"+a);
//        }
//
//
//        System.out.println(a);

        System.out.println(testReturn());

    }

    private static String testReturn(){
        String a = "123";
        try{
            System.out.println("try==>"+a);
//            int b = 1/0;
            return "123";
        }catch (Exception e){
            e.printStackTrace();
//            throw e;
        }finally {
            System.out.println("finally==>"+a);
        }

        return "456";
    }
}
