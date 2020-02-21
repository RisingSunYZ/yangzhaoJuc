package com.yangzhao.java8;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/2/20 14:38
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class StringTest {

    public static void main(String[] args) {
//        String c = new String("b")+new String("a");
//        String d = c.intern();
//        System.out.println(c == d);

        String str2 = new String("str")+new String("01");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2==str1);


        //先去常量池找

        String a = "a"; //常量池
        String b = new String("a"); //常量池  堆，返回堆地址

        String c = "a" + "b"; //常量池  "a""b""ab"

        String d = new String("a")+new String("b"); //池 a，b 堆 ab

        //对于拼接的值，如果都是双引号包裹字符串的形式，则将结果放于constant pool，如果constant pool已经有这个值了，则直接返回这个已有值。
        //而如果拼接的值中，有一个是非双引号包裹字符串的形式，则从heap中开辟一个新的区域保存常量。也即是使用了String变量来做拼接的情况。
        // final 修饰有初始值 当常量，否则 final修饰无初始值还是变量

        //String.intern()方法，可以在runtime期间将常量加入到常量池（constant pool）。它的运作方式是：

        //如果constant pool中存在一个常量恰好等于这个字符串的值，则inter()方法返回这个存在于constant pool中的常量的引用。
        //如果constant pool不存在常量恰好等于这个字符串的值，则在constant pool中创建一个新的常量，并将这个字符串的值赋予这个新创建的在constant pool中的常量。intern()方法返回这个新创建的常量的引用。

    }
}
