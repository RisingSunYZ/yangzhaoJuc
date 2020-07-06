package com.yangzhao.designPattern.template;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/6 16:14
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public abstract class AbstractCookTemplate {

    final void cook(){
        prepare();
        cooking();
        if(isSing()){
            sing();
        }

        gohome();
    };


    private void prepare(){
        System.out.println("做饭前准备");
    }

//    protected abstract boolean isSing();

    //钩子方法
    protected boolean isSing(){
        return true;
    }

    protected abstract void cooking();

    private void sing(){
        System.out.println("去唱歌");
    }

    private void gohome(){
        System.out.println("回家");
    }
}
