package com.effective.ch02.Item2.exam;

/**
 * Created by Yohan lee
 * Created on 2021-10-23.
 **/
public class Item2ExamMain {
	
	public static void main(String[] args) {
		ShrimpPizza shrimpPizza = new ShrimpPizza
				.Builder(ShrimpPizza.Size.MEDIUM)
				.addTopping(Pizza.Topping.MUSHROOM)
				.build();
		
		System.out.printf("맛난 새우피자의 토핑과 사이즈는?? %s, %s%n", shrimpPizza.getToppings(), shrimpPizza.getSize());
		
		CheesePizza cheesePizza = new CheesePizza
				.Builder()
				.sauceInside()
				.border(CheesePizza.Border.CHEESE_CRUST)
				.addTopping(Pizza.Topping.HAM)
				.build();
		
		System.out.printf("담백한 치즈피자의 SPEC~ [%s, %s, 안에 소스? %b]",
				cheesePizza.getToppings(),
				cheesePizza.getBorder(),
				cheesePizza.isSauceInside()
				);
				
	}
}
