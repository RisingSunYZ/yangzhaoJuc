package com.yangzhao.myDemo.linklist;

import java.util.Collection;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/3/31 9:57
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class YzLinkList<E> {

    private int size;

    private static class Node<E>{

        private Node<E> prev;

        private Node<E> next;

        private E val;

        public Node(Node<E> prev, E val,Node<E> next) {
            this.prev = prev;
            this.next = next;
            this.val = val;
        }
    }

    private Node first;

    private Node last;


    public YzLinkList() {
    }

    public void add(E e){

        final Node temp = last;
        Node<E> node = new Node(null,e,null);
        //说明还没有插入过
        if(null == last){
            first = node;
            last = node;
        }else{
            node.prev = temp;
            temp.next = node;
            last = node;
        }
        size ++;
    }


    public void addFirst(E e){
        final Node temp = first;
        Node<E> node = new Node(null,e,temp);
        temp.prev = node;
        first = node;
        size ++;
    }

    public void addAll(Collection<? extends E> collection){
        Object[] objects = collection.toArray();
        if(objects.length > 0){
            Node<E> temp;
            for(int i=0;i<objects.length;i++){
                temp = last;
                Node<E> firstTemp = new Node(temp,(E)objects[i],null);
                temp.next = firstTemp;
                last = firstTemp;
            }
            size += objects.length;
        }
    }

    public void addAll(int index,Collection<? extends E> collection) throws Exception{
        checkAddIndex(index);
        Object[] objects = collection.toArray();
        if(objects.length > 0){
            if(index == size){
                addAll(collection);
            }else if(index == 0){
                Node<E> temp;
                for(int i=objects.length-1;i>=0;i--){
                    temp = first;
                    Node<E> firstTemp = new Node(null,(E)objects[i],temp);
                    temp.prev = firstTemp;
                    first = firstTemp;
                }
                size += objects.length;
            }else{
                Node<E> node = node(index);
                Node<E> prev = node.prev;
                Node<E> next = node;

                Node<E> temp;
                for(int i=0;i<objects.length;i++){
                    Node<E> firstTemp = new Node(prev,(E)objects[i],next);
                    temp = firstTemp;
                    prev.next = firstTemp;
                    next.prev = firstTemp;
                    prev = temp;
                }
                size += objects.length;
            }
        }


    }

    public void add(int index,E e){

        if(index == size){
            add(e);
        }else if(index == 0){
            addFirst(e);
        }else{
            Node<E> node = node(index);
            Node<E> oldPrev = node.prev;
            Node<E> temp = new Node(oldPrev,e,node);
            node.prev = temp;
            oldPrev.next = temp;
            size ++;
        }
    }


    private void checkAddIndex(int index) throws Exception{
        if(!(index >=0 && index <= size)){
            throw new Exception("indexOutOfBounds");
        }
    }

    private void checkIndex(int index) throws Exception{
        if(!(index >=0 && index < size)){
            throw new Exception("indexOutOfBounds");
        }
    }

    public E get(int index) throws Exception{
        checkIndex(index);
        return node(index).val;
    }

    public boolean contains(E e)throws Exception{
        return !(indexOf(e) == -1);
    }

    public int indexOf(E e) throws Exception{
        Node<E> begin = first;
        int index = 0;
        if(null == e){
            for(;begin != null;begin = begin.next){
                if(null == begin.val){
                    return index;
                }
                index ++;
            }
        }else {
            for(;begin != null;begin = begin.next){
                if(e.equals(begin.val)){
                    return index;
                }
                index ++;
            }
        }
        return -1;
    }

    private Node<E> node(int index){
        if(index < size >> 1){

            Node<E> begin = first;
            for( int temp  = 0;temp < index;temp ++){
                begin = begin.next;
            }
            return begin;
        }else{
            Node<E> begin = last;
            for( int temp  = size-1;temp >index;temp --){
                begin = begin.prev;
            }
            return begin;
        }
    }

    public void removeByObj(E e) throws Exception{
        int i = indexOf(e);
        remove(i);
    }

    public void remove(int index) throws Exception{
        checkIndex(index);

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next =  node.next;
        if(null == prev){
            node.next = null;
            next.prev = null;
            first = next;
        }else if(null == next){
            node.prev = null;
            prev.next = null;
            last = prev;
        }else{
            next.prev = prev;
            prev.next = next;
        }
        node.val = null;
        size --;
    }

    public int size(){
        return size;
    }
}
