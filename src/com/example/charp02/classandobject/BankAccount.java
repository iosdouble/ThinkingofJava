package com.example.charp02.classandobject;

/**
 * @ClassName BankAccount
 * @Author nihui
 * @Date 2019/4/21 16:28
 * @Version 1.0
 * @Description TODO
 */
public class BankAccount {

    private double balance; //数据成员

    //构造函数
    public BankAccount(double initBalance) {
        this.balance = initBalance;
    }

    public BankAccount() {
        this.balance = 0;
    }

    //取钱
    public void getBalance(double balance) {
        if (this.balance < balance) {
            System.out.println("您的账户余额不足");
        } else {
            this.balance -= balance;
            System.out.println("您取出了" + balance + ",现在余额" + this.balance);

        }
    }

    //存钱
    public void setBalance(double balance) {
        this.balance += balance;
        System.out.println("您存入了" + balance + ",现在余额" + this.balance);
    }

    public void chackBalance() {
        System.out.println("您的余额为" + this.balance);
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(10);

        bankAccount.getBalance(100);
        bankAccount.setBalance(10000);
        bankAccount.chackBalance();
        bankAccount.getBalance(200);
        bankAccount.chackBalance();


    }


}
