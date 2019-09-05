package cn.cumt.demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        QunZhu qunZhu = new QunZhu("群主",300);
        Member  mumber1 = new Member("群员1",4);
        Member mumber2 = new Member("群员2",31);
        Member mumber3 = new Member("群员3",35);

        Scanner scanner = new Scanner(System.in);
        System.out.println("群主发红包了，发多少钱：");
        int hongbaoMoney = scanner.nextInt();
        System.out.println("群主发红包了，发多少个：");
        int hongbaoCount = scanner.nextInt();
        //发红包
        ArrayList<Double> hongbao = qunZhu.sendMoney(hongbaoMoney,hongbaoCount);
        if (null == hongbao)
        {
            System.out.println("余额不足！！！！请充值");
            return;
        }

        //收红包
        mumber1.openHongBao(hongbao);
        mumber2.openHongBao(hongbao);
        mumber3.openHongBao(hongbao);

        qunZhu.show();
        mumber1.show();
        mumber2.show();
        mumber3.show();

    }
}
