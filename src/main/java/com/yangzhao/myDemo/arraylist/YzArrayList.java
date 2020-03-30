package com.yangzhao.myDemo.arraylist;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/30 16:43
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class YzArrayList<E> implements Serializable {

    private int size;

    private static final Object[] emptyData = {};

    private Object[] elementData;

    private static  final  int DEFAULT_SIZE = 10;


    public YzArrayList() {
        elementData = emptyData;
    }

    public YzArrayList(int initSize) throws Exception{
        if(initSize < 0 ){
            throw new Exception("初始化长度不能小于0");
        }else if(initSize  ==  0){
            elementData = emptyData;
        }else{
            elementData = new Object[initSize];
        }
    }

    private void grow(int minSize){
        int oldSize = elementData.length;
        int newSize = oldSize + oldSize >> 1;
        if(newSize - minSize <=0){
            newSize = minSize;
        }
        elementData = Arrays.copyOf(elementData,newSize);
    }

    private void checkNeedGrow(){
        if(size+1 > elementData.length){
            if(elementData == emptyData){
                grow(DEFAULT_SIZE);
            }else{
                grow(size+1);
            }
        }
    }

    public void add(E o){
        checkNeedGrow();
        elementData[size++] = o;
    }

    public void add(int index,E o) throws Exception{
        checkIndex(index);
        checkNeedGrow();
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        size++;
        elementData[index] = o;
    }

    public int indexOf(E o){
        for(int i=0;i<elementData.length;i++){
            if(null == o){
                if(elementData[i] == null){
                    return i;
                }
            }else{
                if(o.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contatins(E o){
        return this.indexOf(o) != -1;
    }


    public int size(){
        return size;
    }

    private void checkIndex(int index) throws Exception{
        if(index >= size){
            throw new Exception("IndexOutOfBounds");
        }
    }

    public E get(int index) throws Exception{
        checkIndex(index);
        return (E)elementData[index];
    }
    public E remove(int index) throws Exception{
        checkIndex(index);
        E elementDatum = (E)elementData[index];
        System.arraycopy(elementData,index+1,elementData,index,size-index-1);
        elementData[--size] = null;
        return elementDatum;
    }

    public void remove(E o) throws Exception{
        for(int i=0;i<elementData.length;i++){
            if(null == o){
                if(elementData[i] == null){
                    remove(i);
                    break;
                }
            }else{
                if(o.equals(elementData[i])){
                    remove(i);
                    break;
                }
            }
        }
    }

}
