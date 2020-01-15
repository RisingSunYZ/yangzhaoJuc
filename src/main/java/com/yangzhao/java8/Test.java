package com.yangzhao.java8;


public class Test {

    public static void main(String[] args) {

        Yangzhao Yangzhao = new Yangzhao();
        System.out.println(Yangzhao.run());
        System.out.println(Yangzhao.getClass().getName());

        Yangzhao Yangzhao2 = new Yangzhao(){
            @Override
            public String run() {
                return "super.run()";
            }
        };


        System.out.println(Yangzhao2.run());
        System.out.println(Yangzhao2.getClass().getName());

    }
}


class Yangzhao {

    public String run() {
        return "Yangzhao";
    }

}
