package com.yangzhao.designPattern.state;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/19 11:13
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Context extends State{

    public Context(String name, State state) {
        super(name);
        this.state = state;
    }

    private State state ;


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void save(Context context) {
        state.save(context);
    }

    @Override
    public void submit(Context context) {
        state.submit(context);
    }

    @Override
    public void seal(Context context) {
        state.seal(context);
    }

    @Override
    public void toVoid(Context context) {
        state.toVoid(context);
    }
}
