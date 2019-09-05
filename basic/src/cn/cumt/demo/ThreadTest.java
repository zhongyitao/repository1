package cn.cumt.demo;

public class ThreadTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("新的线程！");
        myThread.start();

        for (int i = 0; i <300 ; i++) {
            System.out.println( "main线程正在执行！" + i);
        }
    }
}
