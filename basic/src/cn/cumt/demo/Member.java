package cn.cumt.demo;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User{
    public Member() {
    }

    public Member(String userName, double leftMoney) {
        super(userName, leftMoney);
    }


    public void openHongBao(ArrayList<Double> hongbao){
        Random random = new Random();
        int index = random.nextInt(hongbao.size());
        double money = hongbao.remove(index);
        double leftMoney = getLeftMoney();
        setLeftMoney(leftMoney + money);

    }


}

