package com.yangzhao.designPattern.factory.factorymethod;


//
public interface Factory {

      Animal getAnimal(Class<? extends Animal> clazz) throws Exception;

}
