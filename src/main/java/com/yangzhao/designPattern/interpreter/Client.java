package com.yangzhao.designPattern.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/18 14:31
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 *
 * 个人理解 解释器模式 主要就是 终结符表达式 和 非终结符表达式  其实类似于递归的思想
 */
public class Client {

    public static void main(String[] args) throws Exception{
        String expStr = getExpStr(); // a+b
        HashMap<String, Integer> var = getValue(expStr);// var {a=10, b=20}
        Context context = new Context(expStr);
        System.out.println(context.execute(var));

    }

    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static HashMap<String, Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();

        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.print("请输入" + String.valueOf(ch) + "的值");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }

        return map;
    }


}
