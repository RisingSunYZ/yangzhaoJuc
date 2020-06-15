package com.yangzhao.designPattern.proto;

import java.io.*;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/11 17:15
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Person implements Cloneable, Serializable {



    private Integer age;

    private String name;

    private Person borther;

    public Person(Integer age, String name, Person borther) {
        this.age = age;
        this.name = name;
        this.borther = borther;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getBorther() {
        return borther;
    }

    public void setBorther(Person borther) {
        this.borther = borther;
    }

    public Person myClone(){
        Object o = null;
        ByteArrayInputStream bai = null;
        ObjectInputStream ois = null;
        ByteArrayOutputStream boi = null;
        ObjectOutputStream oos = null;
        try{
            boi = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(boi);
            oos.writeObject(this);
            bai = new ByteArrayInputStream(boi.toByteArray());
            ois = new ObjectInputStream(bai);
            o = ois.readObject();
            return (Person)o;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                bai.close();
                ois.close();
                boi.close();
                oos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return (Person)o;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person clone = (Person)super.clone();
        Person borther = clone.getBorther();
        if(borther != null){
            Person clone1 = (Person)borther.clone();
            clone.setBorther(clone1);
        }
        return clone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", borther=" + borther +
                '}';
    }
}
