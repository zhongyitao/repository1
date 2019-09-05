package cn.cumt.demo;

import java.util.Random;
import java.util.Scanner;

public class DemoRandom {
    public static void main(String[] args) {
        int n = 10;
        Random random = new Random();

        int result = random.nextInt(n);
        Scanner scn = new Scanner(System.in);
        //int num1 = input(scn);
        int c= 0;
        while (true)
        {
            int num1 = input(scn);

            c+=1;
            if (num1==result)
            {
                System.out.println("恭喜你猜对了，答案是："+result+"-----你猜了"+c+"次");
                break;

            }
            else if (num1<result)
            {
                System.out.println("你猜的太小了，继续猜呀");
            }

            else {
                System.out.println("你猜的太大了，继续猜呀");
            }
        }
    }

    public static int input(Scanner scn){
        System.out.println("你来猜一猜：");
        int b = scn.nextInt();
        return b;
    }
}
