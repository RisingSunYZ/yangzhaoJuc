package com.yangzhao.designPattern.single;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/4/30 17:37
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class InnerClassSingle {

    private InnerClassSingle(){
        System.out.println("InnerClassSingle......................");
    }


    static class InnerClass{
        private InnerClassSingle innerClassSingle = new InnerClassSingle();
    }
}
