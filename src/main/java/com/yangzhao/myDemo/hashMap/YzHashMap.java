package com.yangzhao.myDemo.hashMap;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/4/23 13:25
 * @Version:1.1.0
 *
 *
 * 只是简单实现Java7 数组+链表结构 采用头插法，实现动态扩容
 * 具体 下标的算法，包括扰动函数，大小是2额幂 ，负载因子过大过小问题 这里不详细实现，
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class YzHashMap<K,V> {

    private final Integer DEFAULT_INIT_SIZE = 16;

    private Node<K,V>[] table;

    private Float fzyz = 0.75f;

    private int size;

    class Node<K,V>{

        K k;
        V v;
        Node<K,V> next;
        int hash;


        public Node(K k, V v, Node<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    public void forEachYzMap(){
        for(int i=0;i<table.length;i++){

            Node<K,V> nodeTemp = table[i];
            if(null != nodeTemp){
                System.out.println("Index"+i+"=======================begin");
                while(null != nodeTemp){
                    System.out.println("key="+nodeTemp.k+"   "+"value="+nodeTemp.v);
                    System.out.println();
                    nodeTemp = nodeTemp.next;
                }
                System.out.println("Index"+i+"=======================end");
            }
        }
    }



    public YzHashMap() {
    }

    private void resize(){
        System.out.println("扩容了======================");
        Node<K,V>[] oldTable = table;
        Node<K,V>[] newTable = new Node[table.length * 2];

        for(int i=0;i<oldTable.length;i++){

            Node<K,V> nodeTemp = oldTable[i];
            if(null != nodeTemp){
                while(null != nodeTemp){

                    K oldk = nodeTemp.k;
                    int index = null== oldk?0:getIndex(oldk,newTable.length);
                    if(null == newTable[index]){
                        newTable[index] = new Node<>(nodeTemp.k,nodeTemp.v,null);
                    }else{

                        Node<K,V> tempNode = newTable[index];
                        boolean flag = false;
                        while(tempNode != null ){
                            if(null == nodeTemp.k){
                                if(tempNode.k == null){
                                    tempNode.v = nodeTemp.v;
                                    flag = true;
                                    break;
                                }
                            }else{
                                if(tempNode.k == nodeTemp.k && tempNode.k.equals(nodeTemp.k)){
                                    tempNode.v = nodeTemp.v;
                                    flag = true;
                                    break;
                                }
                            }
                            tempNode = tempNode.next;
                        }

                        if(!flag){
                            Node<K,V> tempNode2 = newTable[index];
                            Node<K,V> now = new Node<>(nodeTemp.k,nodeTemp.v,tempNode2);
                            newTable[index] = now;
                        }
                    }
                    nodeTemp = nodeTemp.next;
                }
            }
        }
        table = newTable;

    }


    private int getIndex(K k,int length){
        return k.hashCode() % (length-1);
    }

    public int size(){
        return size;
    }

    public V get(K k){
        if(null == k){
            Node<K,V> temp0 = table[0];
            if(null == temp0){
                return null;
            }
            while(temp0!=null){
                if(null == temp0.k){
                    return temp0.v;
                }
                temp0 = temp0.next;
            }

        }else{
            int index = getIndex(k,table.length);
            Node<K,V> tempIndex = table[index];

            if(null == tempIndex){
                return null;
            }
            while(tempIndex!=null){
                if(k == tempIndex.k && k.equals(tempIndex.k)){
                    return tempIndex.v;
                }
                tempIndex = tempIndex.next;
            }

        }
        return null;
    }

    public V put(K k,V v){
        if(null == table){
            table = new Node[DEFAULT_INIT_SIZE];
        }

        if(null == k){
            if(null == table[0]){
                table[0] = new Node<>(k,v,null);
                size++;
            }else{
                Node<K,V> temp = table[0];
                boolean hasNullKey = false;
                do{
                    if(null == temp.k){
                        V oldVal = temp.v;
                        temp.v = v;
                        hasNullKey = true;
                        return oldVal;
                    }
                    temp = temp.next;
                }while (null != temp);

                if(!hasNullKey){
                    Node<K,V> temp2  = table[0];
                    table[0] = new Node<>(k,v,temp2);
                    size++;
                }
            }
        }else{

            if(table.length * fzyz < size){
                resize();
            }
            int index = getIndex(k,table.length);

            Node<K,V> temp = table[index];

            if(null == temp){
                table[index] = new Node<>(k,v,null);
                size++;
            }else{
                boolean hasNullKey = false;
                do{
                    if(k == temp.k && k.equals(temp.k)){
                        V oldVal = temp.v;
                        temp.v = v;
                        hasNullKey = true;
                        return oldVal;
                    }
                    temp = temp.next;
                }while (null != temp);

                if(!hasNullKey){
                    Node<K,V> temp2  = table[index];
                    table[index] = new Node<>(k,v,temp2);
                    size++;
                }
            }

        }
        return null;
    }


    public V remove(K k){
        if(null == k){
            Node<K,V> temp0 = table[0];
            Node<K,V> tempPrev = null;
            if(null == table[0].k){
                V v = table[0].v;
                table[0] = table[0].next;
                return v;
            }else{
                while(null != temp0){
                    if(null == temp0.k){
                        V v = temp0.v;
                        tempPrev.next = temp0.next;
                        temp0 = null;
                        return v;
                    }
                    tempPrev = temp0;
                    temp0 = temp0.next;
                }
            }
        }else{
            int index = getIndex(k,table.length);
            Node<K,V> temp0 = table[index];
            Node<K,V> tempPrev = null;
            if(table[index] == null){
                return null;
            }

            if(k == table[index].k && k.equals(table[index].k)){
                V v = table[index].v;
                table[index] = table[index].next;
                return v;
            }else{
                while(null != temp0){
                    if(k == temp0.k && k.equals(temp0.k)){
                        V v = temp0.v;
                        tempPrev.next = temp0.next;
                        temp0 = null;
                        return v;
                    }
                    tempPrev = temp0;
                    temp0 = temp0.next;
                }
            }
        }
        return null;
    }
}
