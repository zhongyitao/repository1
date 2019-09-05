package cn.cumt.practice;


/*
使用线程池创建多线程。模拟同学找老师学习Java。
    创建线程池对象，包含2个线程。从线程池中获取线程对象，然后调用MyRunnable中的run()。
    在MyRunnable实现类中，首先在控制台打印需求，“我需要一个老师”。
    模拟需要2秒钟时间老师可以过来指导学生，并在控制台打印老师的姓名。
    最后，在控制台打印“教我java,教完后，老师回到了办公室”；

*/

/*
创建一个顾客线程(消费者):告知老板要的包子的种类和数量,调用wait方法,放弃cpu的执行,进入到WAITING状态(无限等待)
创建一个老板线程(生产者):花了5秒做包子,做好包子之后,调用notify方法,唤醒顾客吃包子
*/


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPool {

    public static void main(String[] args) {
        //Object o = new Object();
        Lock lock = new ReentrantLock();
        Runnable r = () -> {
            System.out.println("我需要一个java老师");

            //lock.lock();
            synchronized (lock) {
                System.out.println("java1老师来了");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("教我java,教完后，老师回到了办公室");
            }
            //lock.unlock();

        };

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.submit(r);
        threadPool.submit(r);
        //threadPool.submit(r);
        //threadPool.shutdown();
        //threadPool.submit(r);







    }
}
