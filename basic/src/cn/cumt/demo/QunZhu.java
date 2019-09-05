package cn.cumt.demo;

import java.util.ArrayList;

public class QunZhu extends User{

    public QunZhu() {
    }

    public QunZhu(String userName, double leftMoney) {
        super(userName, leftMoney);
    }

    public ArrayList<Double> sendMoney(int money, int count)
    {
        //获取群主余额
        double leftMoney = getLeftMoney();
        //看余额够不够发
        if(money>leftMoney)
        {
            return null;
        }
        else
        {
            //修改余额
            setLeftMoney(leftMoney - money);
            //创建集合
            ArrayList<Double> hongbao = new ArrayList<Double>();
            //缩小单位
            money = money*100;
            //每份金额
            int m = money / count;
            //余数
            int l = money % count;
            //加入集合
            for (int i = 0; i < count-1; i++) {

                hongbao.add(m/100.0);
            }

            //判断是否有余数
            if (l == 0)
            {
                hongbao.add(m/100.0);
            }
            else
            {
                hongbao.add(m/100.0+l);
            }

            return hongbao;
        }
    }
}
