package com.yangzhao.juc;

import java.io.IOException;
import java.util.concurrent.Phaser;

public class PhaserDemo {

  public static void main(String[] args) throws IOException {

    int l = 4;//轮数
    int xc = 3;//线程数


    Phaser Phaser = new Phaser(xc){
      @Override
      protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("第"+phase+"轮结束"+",总共"+registeredParties+"轮");
        System.out.println(registeredParties == 0);
        return registeredParties == 0; //返回false才能继续
      }
    };


    for(int i=0;i<xc;i++){
      Thread t = new Thread(()->{
        for(int j=0;j<l;j++){
          System.out.println(Thread.currentThread()+"完成"+j+"轮工作");
          Phaser.arriveAndAwaitAdvance();
        }
      },""+i);
      t.start();
    }



  }
}