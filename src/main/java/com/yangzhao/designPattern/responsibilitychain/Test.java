package com.yangzhao.designPattern.responsibilitychain;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/19 18:52
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 * 请求发送者和处理者解耦
 * 链不能太长 性能不好 ，可以判断链不要超过杜少
 * 链可以是图 树
 * 可以闭环
 * 本例子 没判断非空 也不是闭环 所以存在无人处理的情况
 *
 */
public class Test {

    public static void main(String[] args) {

        VolicationRequest VolicationRequest = new VolicationRequest(15);

        TeamHandler TeamHandler = new TeamHandler("组长");
        DeptHandler DeptHandler = new DeptHandler("部长");
        CompanyHandler CompanyHandler = new CompanyHandler("董事长");
        TeamHandler.setNextHandler(DeptHandler);
        DeptHandler.setNextHandler(CompanyHandler);

        TeamHandler.handler(VolicationRequest);


    }
}
