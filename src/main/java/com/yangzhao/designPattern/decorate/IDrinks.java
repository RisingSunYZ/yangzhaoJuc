package com.yangzhao.designPattern.decorate;

public abstract class IDrinks {

    float price = 0.0f;

    abstract void say();

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
