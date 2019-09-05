package cn.cumt.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitAndNotifyTest {

    public static void main(String[] args) {

         BaoZi bz = new BaoZi();

        Lock lock = new ReentrantLock();

        Runnable zhuoBaozi = () -> {

            //定义一个变量
            int count = 0;
            //让包子铺一直生产包子
            while(true){
                //必须同时同步技术保证两个线程只能有一个在执行
                //lock.lock();
                synchronized (bz){
                    //对包子的状态进行判断
                    if(bz.flag==true){
                        //包子铺调用wait方法进入等待状态
                        try {
                            bz.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //被唤醒之后执行,包子铺生产包子
                    //增加一些趣味性:交替生产两种包子
                    if(count%2==0){
                        //生产 薄皮三鲜馅包子
                        bz.pi = "薄皮";
                        bz.xian = "三鲜馅";
                    }else{
                        //生产 冰皮 牛肉大葱陷
                        bz.pi = "冰皮";
                        bz.xian = "牛肉大葱陷";

                    }
                    count++;
                    System.out.println("包子铺正在生产:"+bz.pi+bz.xian+"包子");
                    //生产包子需要3秒钟
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //包子铺生产好了包子
                    //修改包子的状态为true有
                    bz.flag = true;
                    //唤醒吃货线程,让吃货线程吃包子
                    bz.notify();
                    System.out.println("包子铺已经生产好了:"+bz.pi+bz.xian+"包子,吃货可以开始吃了");
                //lock.unlock();
            }
            }
        };


        Runnable chihuo = () -> {

            //使用死循环,让吃货一直吃包子
            while (true){
                //必须同时同步技术保证两个线程只能有一个在执行
                synchronized (bz){
                //lock.lock();
                //对包子的状态进行判断
                    if(bz.flag==false){
                        //吃货调用wait方法进入等待状态
                        try {
                            bz.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //被唤醒之后执行的代码,吃包子
                    System.out.println("吃货正在吃:"+bz.pi+bz.xian+"的包子");
                    //吃货吃完包子
                    //修改包子的状态为false没有
                    bz.flag = false;
                    //吃货唤醒包子铺线程,生产包子
                    bz.notify();
                    System.out.println("吃货已经把:"+bz.pi+bz.xian+"的包子吃完了,包子铺开始生产包子");
                    System.out.println("----------------------------------------------------");
            //lock.unlock();
            }
            }
        };


        new Thread(zhuoBaozi).start();
        new Thread(chihuo).start();

    }

}
