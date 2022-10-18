package com.lannstark.lec12;

public class Lec12Main {

  public static void main(String[] args) {
    JavaPerson javaPerson = JavaPerson.newBaby("ABC");
    moveSomething(new Movable() {
      @Override
      public void move() {

      }

      @Override
      public void fly() {

      }
    });
  }

  private static void moveSomething(Movable movable) {
    movable.move();
    movable.fly();
  }


}
