package com.effective.ch02.Item2;

import lombok.Getter;

/**
 * Created by Yohan lee
 * Created on 2021-09-27.
 **/

@Getter
public class NutritionFacts_Builder {
	
	//ml / 1회 제공량(필수)
	private int serviceSize;
	
	//회 / 총 n회 제공량(필수)
	private int servings;
	
	//1회 제공량당(선택)
	private int calories;
	
	//g / 1회 제공량당(선택)
	private int fat;
	
	//mg / 1회 제공량당(선택)
	private int sodium;
	
	//g / 1회 제공량당(선택)
	private int carbohydrate;
	
	public static class Builder {
		//필수 매개변수
		private final int serviceSize;
		private final int servings;
		
		//Optional한 매개변수는 고정값을 지정하여 초기화 한다.
		private int calories = 0;
		
		private int fat = 0;
		
		private int sodium = 0;
		
		private int carbohydrate = 0;
		
		//new 키워드를 사용하지 않고, 생성하기 위해 정적 팩토리메소드 추가.
		public static Builder builder(int serviceSize, int servings) {
			return new Builder(serviceSize, servings);
		}
		
		private Builder(int serviceSize, int servings) {
			this.serviceSize = serviceSize;
			this.servings = servings;
		}
		
		public Builder calories(int value) {
			calories = value;
			return this;
		}
		
		public Builder fat(int value) {
			fat = value;
			return this;
		}
		
		public Builder sodium(int value) {
			sodium = value;
			return this;
		}
		
		public Builder carbohydrate(int value) {
			carbohydrate = value;
			return this;
		}
		
		//build 시, 생성.
		public NutritionFacts_Builder build() {
			return new NutritionFacts_Builder(this);
		}
		
	}
	
	private NutritionFacts_Builder(Builder builder) {
		serviceSize = builder.serviceSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
}
