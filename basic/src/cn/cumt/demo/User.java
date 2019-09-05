package cn.cumt.demo;

public class User {

    private String userName;
    private double leftMoney;

    public User(String userName, double leftMoney) {
        this.userName = userName;
        this.leftMoney = leftMoney;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }


    public void show()
    {
        System.out.println("用户名："+userName+"---余额："+leftMoney);
    }
}
