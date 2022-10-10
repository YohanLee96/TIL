package com.effective.ch02.Item2;

/**
 * Created by Yohan lee
 * Created on 2021-09-26.
 * 생성자에 매개변수가 많다면 빌더를 고려하라
 **/
public class Item2Main {
	
	public static void main(String[] args) {
		/**
		 * Bad Case 1 - 점층적 생성자 패턴
		 * 단점
		 * 1. 매개변수가 많아지면 코드를 읽을 때 각 값의 의미를 파악하기가 어렵다.
		 * 2. 타입이 같은 매개변수가 많다면 휴먼에러가 발생할 확률이 높아진다.
		 */
		NutritionFacts_Bad hamburger = new NutritionFacts_Bad(60, 300);
		System.out.println("1회 제공량 = " + hamburger.getServiceSize() + ", n회 제공량 = " + hamburger.getServings());
		
		/**
		 * Bad Case2 - Java Beans 패턴(각각의 필드에 Setter 메소드 부여)
		 * 단점
		 * 1. 객체하나를 만들고자 할 때, 여러개의 메소드를 사용해야한다.
		 * 2. 클래스를 불변으로 만들기 위해 각각의 필드를 private하게 만든 이유가 사라진다.
		 */
		NutritionFacts_Bad2 pizza = new NutritionFacts_Bad2();
		pizza.setServiceSize(60);
		pizza.setServings(300);
		pizza.setCalories(705);
		pizza.setCarbohydrate(30);
		System.out.println("1회 제공량 = " + pizza.getServiceSize() + ", n회 제공량 = " + pizza.getServings());
		
		/**
		 * Good Case - Builder 패턴
		 * (메소드 체이닝을 통해, 코드 가독성을 모두 잡을 수 있으며 객체 생성 이후 불변성을 유지할 수 있다.)
		 * 생성자 매개변수가 4개이상일경우, 효율적이다.
		 * 단점
		 * 1. 코드의 양이 위 Case1,2보다 좀 더 많아진다. 허나, Lombok의 Builder 어노테이션을 사용한다면 해결.
		 */
		NutritionFacts_Builder stake = NutritionFacts_Builder.Builder
				.builder(600, 30)
				.calories(30)
				.carbohydrate(50)
				.fat(40)
				.carbohydrate(50)
				.build();
		
		System.out.println("1회 제공량 = " + stake.getServiceSize() + ", n회 제공량 = " + stake.getServings());
	}

}
