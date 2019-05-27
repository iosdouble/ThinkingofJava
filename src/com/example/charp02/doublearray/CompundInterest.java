package com.example.charp02.doublearray;

import java.text.*;
import javax.swing.*;

/**
 * @ClassName CompundInterest
 * @Author nihui
 * @Date 2019/5/1 12:45
 * @Version 1.0
 * @Description TODO
 */
public class CompundInterest {

    public static void main(String[] args) {
        final int STARTRATE = 10;
        final int NRATES = 6;
        final int NYEARS = 10;
        
        double[] interestRate = new double[NRATES];
        for (int i = 0; i < interestRate.length; i++) {
            interestRate[i] = (STARTRATE+i)/100.0;
        }
        double[][] balance = new double[NYEARS][NRATES];

        for (int i = 0; i < balance[0].length; i++) {
            balance[0][i] = 1000;
        }
        for (int i = 1; i <balance.length ; i++) {
            for (int j = 0; j < balance[i].length;j++) {
                double oldBalance = balance[i-1][j];
                double interest = oldBalance*interestRate[j];
                balance[i][j] = oldBalance+interest;
            }
        }

        NumberFormat formatPercent = NumberFormat.getPercentInstance();
        for (int i = 0; i < interestRate.length; i++) {
            System.out.print("      ");
            System.out.print("  "+formatPercent.format(interestRate[i]));
        }
        System.out.println();
        
        NumberFormat formatCurrency = NumberFormat.getCurrencyInstance();

        for (int i = 0; i < balance.length; i++) {
            for (int j = 0; j < balance[i].length; j++) {
                System.out.print("  ");
                System.out.print(formatCurrency.format(balance[i][j]));
            }
            System.out.println();
        }
        
    }

}
