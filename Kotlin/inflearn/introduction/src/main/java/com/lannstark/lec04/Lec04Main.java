package com.lannstark.lec04;

public class Lec04Main {

    public static void main(String[] args) {
        JavaMoney money1 = new JavaMoney(3_000L);
        JavaMoney money2 = new JavaMoney(2_000L);
        JavaMoney money3 = new JavaMoney(3_000L);
        if (money1.compareTo(money2) > 0) {
            System.out.println("Money1이 Money2보다 금액이 큽니다.");
        }

        //주소 비교이기 때문에 false
        System.out.println(money1 == money3);
        //값 비교이기 때문에 true
        System.out.println(money1.equals(money3));


        System.out.println(money1.plus(money2).toString());



    }

}
