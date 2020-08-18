package com.yangzhao.designPattern.interpreter;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/8/18 14:33
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class Context {

    private Express express;

    public Context(String str) {
        Stack<Express> statck = new Stack();
        char[] cahrs = str.toCharArray();

        for(int i=0;i<cahrs.length;i++){
            switch (cahrs[i]){
                case '+':
                    Express left = statck.pop();
                    VarExpress right = new VarExpress(String.valueOf(cahrs[++i]));
                    AddSynbolExpress add = new AddSynbolExpress(left,right);
                    statck.push(add);
                    break;
                case '-':
                    Express left1 = statck.pop();
                    VarExpress right2 = new VarExpress(String.valueOf(cahrs[++i]));
                    SubSynbolExpress sub = new SubSynbolExpress(left1,right2);
                    statck.push(sub);
                    break;
                default:
                    statck.push(new VarExpress(String.valueOf(cahrs[i])));
            }
        }

        express = statck.pop();

    }

    public int execute(HashMap<String, Integer> var){
        return express.interpreter(var);
    }
}
