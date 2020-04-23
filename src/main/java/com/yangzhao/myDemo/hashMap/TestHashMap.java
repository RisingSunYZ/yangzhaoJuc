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

//
        YzHashMap<String,String> YzHashMap = new YzHashMap();

        YzHashMap.put(null,"1");

        YzHashMap.put("18","1");
        YzHashMap.put("27","2");
        YzHashMap.put("36","3");
        YzHashMap.put("45","4");

        YzHashMap.put("19","5");
        YzHashMap.put("28","6");
        YzHashMap.put("37","7");
        YzHashMap.put("46","8");



//        YzHashMap.put("2","9");
//        YzHashMap.put("59","10");
//        YzHashMap.put("68","11");
//        YzHashMap.put("77","12");
//
//        YzHashMap.put("8","13");
//        YzHashMap.put("33","14");
//        YzHashMap.put("5","15");
//        YzHashMap.put("666","16");



        String remove = YzHashMap.remove("77");
        String remove1 = YzHashMap.remove("77");
        String remove2 = YzHashMap.remove("37");
        String remove3 = YzHashMap.remove("27");
        System.out.println(remove);
        System.out.println(remove1);
        System.out.println(remove2);
        System.out.println(remove3);
//
//        YzHashMap.forEachYzMap();


//        System.out.println(YzHashMap.size());
//        YzHashMap.forEachYzMap();


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
