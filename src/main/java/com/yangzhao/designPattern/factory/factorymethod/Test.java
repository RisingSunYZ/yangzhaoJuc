package com.yangzhao.designPattern.factory.factorymethod;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/6/10 16:52
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) throws Exception{

//        Animal animal = AnimalFactory.getAnimal(Dog.class);
//        animal.say();
//
//        Animal animal1 = AnimalFactory.getAnimal(Cat.class);
//        animal1.say();


        Factory factory = new MyCatFactory();
        Animal animal = factory.getAnimal(Cat.class);
        animal.say();

        Factory factory1 = new MyDogFactory();
        Animal animal1 = factory1.getAnimal(Dog.class);
        animal1.say();
//         AnimalFactory<Animal> AnimalFactory = new AnimalFactory<Animal>();
//        Animal animal = AnimalFactory.getAnimal(Dog.class);
//        animal.say();
    }

}
