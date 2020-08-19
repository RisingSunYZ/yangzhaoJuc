package com.yangzhao.designPattern.state;

public abstract class State {

    protected String name;

    public State(String name) {
        this.name = name;
    }

    //保存
    abstract void save(Context context);
    //提交
    abstract void submit(Context context);
    //盖章
    abstract void seal(Context context);
    //作废
    abstract void toVoid(Context context);

}

class noSubmitState extends State{

    public noSubmitState(String name) {
        super(name);
    }

    @Override
    public void save(Context context) {
        System.out.println(this.name+ "可以保存");
        context.setState(new noSubmitState("未提交"));
    }

    @Override
    public void submit(Context context) {
        System.out.println(this.name+"可以提交");
        context.setState(new submitingState("审批中"));
    }

    @Override
    public void seal(Context context) {
        System.out.println(this.name+"不可以盖章");
    }

    @Override
    public void toVoid(Context context) {
        System.out.println("作废");
        context.setState(new toVoidState("作废"));
    }
}

class submitingState extends State{

    public submitingState(String name) {
        super(name);
    }

    @Override
    public void save(Context context) {
        System.out.println(this.name+"不可以保存");
    }

    @Override
    public void submit(Context context) {
        System.out.println(this.name+"不可以提交");
    }

    @Override
    public void seal(Context context) {
        System.out.println("生效");
        context.setState(new sealingState("已生效"));
    }

    @Override
    public void toVoid(Context context) {
        System.out.println(this.name+"不可以作废");
    }
}

class sealingState extends State{

    public sealingState(String name) {
        super(name);
    }

    @Override
    public void save(Context context) {
        System.out.println(this.name+"不可以保存");
    }

    @Override
    public void submit(Context context) {
        System.out.println(this.name+"不可以提交");
    }

    @Override
    public void seal(Context context) {
        System.out.println(this.name+"不可以生效");
    }

    @Override
    public void toVoid(Context context) {
        System.out.println(this.name+"不可以作废");
    }
}

class toVoidState extends State{

    public toVoidState(String name) {
        super(name);
    }

    @Override
    public void save(Context context) {
        System.out.println(this.name+"不可以保存");
    }

    @Override
    public void submit(Context context) {
        System.out.println(this.name+"不可以提交");
    }

    @Override
    public void seal(Context context) {
        System.out.println(this.name+"不可以盖章");
    }

    @Override
    public void toVoid(Context context) {
        System.out.println(this.name+"不可以作废");
    }
}
