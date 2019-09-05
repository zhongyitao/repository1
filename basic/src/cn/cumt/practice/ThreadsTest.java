package cn.cumt.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ThreadsTest {


        public int start = 1;
        public int end = 99;
        public static void main (String[] args) {
            new ThreadsTest().method();
        }


        public void method() {
        //请在此处插入代码，实现功能


            Thread t = new Thread(() -> {

                for (int i = 1; i < 100 ; i++) {
                    System.out.println(i);
                }
            });
            t.start();


        }




}
