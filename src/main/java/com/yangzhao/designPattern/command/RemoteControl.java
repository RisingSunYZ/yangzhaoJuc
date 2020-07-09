package com.yangzhao.designPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:YangZhao
 * @Since:2020/7/9 16:06
 * @Version:1.1.0
 * @Copyright:Copyright (c) 浙江蘑菇加电子商务有限公司 2018 ~ 2026 版权所有
 */
public class RemoteControl {

    private List<ICommand> onCommand = new ArrayList<>();
    private List<ICommand> offCommand = new ArrayList<>();

    private ICommand undoCommand;


    public void setCommand(int index,ICommand onCommandParam,ICommand offCommandParam){
        onCommand.add(index,onCommandParam);
        offCommand.add(index,offCommandParam);
    }

    public void unDo(){
        undoCommand.excute();
    }


    public void on (){
        onCommand.forEach(o->{
            o.excute();
        });
    }


    public void on (int index){
        if(null != onCommand.get(index)){
            onCommand.get(index).excute();
            undoCommand = offCommand.get(index);
        }

    }

    public void off (int index){
        if(null !=offCommand.get(index)){
            offCommand.get(index).excute();
            undoCommand = onCommand.get(index);
        }

    }


    public void off (){
        offCommand.forEach(o->{
            o.excute();
        });
    }


}
