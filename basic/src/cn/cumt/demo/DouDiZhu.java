package cn.cumt.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class DouDiZhu {

    public static void main(String[] args) {
        //创建花色
        ArrayList<String> colors = new ArrayList<>();
        Collections.addAll(colors,"♥","♦","♠","♣");
        //创建数字
        ArrayList<String> numbers = new ArrayList<>();
//        for (int i = 2; i <= 10 ; i++) {
//            numbers.add(i + "");
//        }
//        Collections.addAll(numbers,"J","Q","K","A");
        Collections.addAll(numbers,"2","A","K","Q","J","10","9","8","7","6","5","4","3");

        //创建牌面
        //创建map牌盒
        HashMap<Integer,String> pokerMap = new HashMap<>();
        int count = 0;
        pokerMap.put(count,"大☠");
        count++;
        pokerMap.put(count,"小☺");
        count++;

        for (String number : numbers) {
            for (String color : colors) {
                pokerMap.put(count,color+number);
                count++;
            }
        }


        //取map键值
        Set<Integer> pokerKeySet = pokerMap.keySet();


        //打乱顺序
        ArrayList<Integer> pokerKeys = new ArrayList<>();
        pokerKeys.addAll(pokerKeySet);
        Collections.shuffle(pokerKeys);

        //创建三个牌友和底牌盒
        ArrayList<Integer> playerNo2 = new ArrayList<>();
        ArrayList<Integer> playerNo3 = new ArrayList<>();
        ArrayList<Integer> playerNo1 = new ArrayList<>();
        ArrayList<Integer> diPaiNo = new ArrayList<>();


        //摸牌
        for (int i = 0; i < pokerKeys.size(); i++) {
            Integer no = pokerKeys.get(i);
            if (i>=51)
            {
                diPaiNo.add(no);
            }
            else
            {
                if (i % 3 == 0)
                {
                    playerNo1.add(no);
                }
                else if (i % 3 == 1)
                {
                    playerNo2.add(no);
                }
                else
                {
                    playerNo3.add(no);
                }
            }
        }

        //排序
        Collections.sort(playerNo1);
        Collections.sort(playerNo2);
        Collections.sort(playerNo3);
        Collections.sort(diPaiNo);
        //展示牌面

        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        for (Integer a : playerNo1)
        {

            player1.add(pokerMap.get(a));
        }
        for (Integer b : playerNo2)
        {
            player2.add(pokerMap.get(b));
        }
        for (Integer c : playerNo3)
        {
            player3.add(pokerMap.get(c));
        }
        for (Integer d : diPaiNo)
        {
            diPai.add(pokerMap.get(d));
        }

        System.out.println("洪七公：" + player1);
        System.out.println("欧阳锋：" + player2);
        System.out.println("黄药师：" + player3);
        System.out.println("底牌：" + diPai);
    }

}
