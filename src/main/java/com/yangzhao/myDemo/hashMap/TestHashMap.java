package com.yangzhao.myDemo.hashMap;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/4/23 13:25
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class TestHashMap {

    public static void main(String[] args) {


        YzHashMap<String,String> YzHashMap = new YzHashMap();

        YzHashMap.put(null,"1");
        YzHashMap.put("18","1");
        YzHashMap.put("27","1");
        YzHashMap.put("36","1");
        YzHashMap.put("45","1");

        YzHashMap.put("19","1");
        YzHashMap.put("28","1");
        YzHashMap.put("37","1");
        YzHashMap.put("46","1");


        YzHashMap.put("2","1");
        YzHashMap.put("59","1");
        YzHashMap.put("68","1");
        YzHashMap.put("77","1");

        YzHashMap.put("8","1");
        YzHashMap.put("33","1");
        YzHashMap.put("5","1");
        YzHashMap.put("666","1");


        YzHashMap.put("46","222");

        YzHashMap.put("8","222");

        YzHashMap.put(null,"222");

        System.out.println(YzHashMap.size());
        YzHashMap.forEachYzMap();


//        Map<Integer, List<String>> map = new HashMap<>();
//
//        for(int i=0;i<100;i++){
//            int index = (""+i).hashCode() % 15;
//            if(map.containsKey(index)){
//                List<String> strings = map.get(index);
//                strings.add(""+i);
//                map.put(index,strings);
//            }else{
//                List<String> strings = new ArrayList<>();
//                strings.add(""+i);
//                map.put(index,strings);
//            }
//        }
//
//        for(Map.Entry<Integer,List<String>> entry:map.entrySet()){
//            System.out.println("======index====================");
//            System.out.println(entry.getKey());
//            List<String> value = entry.getValue();
//            System.out.println("======value====================");
//            value.forEach(v-> System.out.println(v));
//            System.out.println();
//        }

    }
}
