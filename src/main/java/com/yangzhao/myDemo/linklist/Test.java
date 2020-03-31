package com.yangzhao.myDemo.linklist;

import java.util.ArrayList;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/31 9:51
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 *
 * 从JDK1.7开始，LinkedList 由双向循环链表改为双向链表
 *
 */
public class Test {

    public static void main(String[] args) throws Exception{

//
//        LinkedList LinkedList2 = new LinkedList();
//        LinkedList2.addAll(new ArrayList());

        YzLinkList<String> LinkedList = new YzLinkList();

        LinkedList.add("1");
        LinkedList.add("2");
        LinkedList.add("3");
        LinkedList.add("4");
        LinkedList.add("5");

        ArrayList<String> strings = new ArrayList();
        strings.add("6");
        strings.add("7");
        strings.add("8");

        LinkedList.addAll(1,strings);


        for(int i=0;i<LinkedList.size();i++){
            System.out.println(LinkedList.get(i));
        }

    }
}
