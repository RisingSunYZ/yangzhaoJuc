package com.yangzhao.designPattern.state;

/**
 *
 * 抽出不变的是行为 变得是状态
 * 此demo 有 四种行为 四种状态
 * 每个状态里面都对当前状态的四种行为进行重写
 *
 * Context 和 State 互持双方引用
 *
 * Context 里面写行为 其实还是调用state的方法
 *
 * state 里面 对自己的状态 一般就是 不可以处理 可以处理的话 一般还会把context里面换成另一种状态
 *
 *
 */
public class Test {


    public static void main(String[] args) {
        Context context = new Context("",new noSubmitState(""));

        context.save(context);
        context.submit(context);
        context.seal(context);
        context.toVoid(context);



    }
}
