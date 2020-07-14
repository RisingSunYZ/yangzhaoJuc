package com.yangzhao.designPattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/14 14:46
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Test {

    public static void main(String[] args) {

        List<College> colleges = new ArrayList<>();
        colleges.add(new InfoCollege());
        colleges.add(new ComputerCollege());
        OutPutData OutPutData = new OutPutData(colleges);
        OutPutData.outPut();


    }
}
