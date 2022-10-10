package com.effective.ch02.Item2;

import lombok.Getter;

/**
 * Created by Yohan lee
 * Created on 2021-09-27.
 * 식품 포장의 영양정보를 포함하는 POJO 객체.
 * 점층적 생성자 패턴 사용 -> 생성자의 매개변수를 점층적으로 1개씩 늘려가는 방식.
 **/
@Getter
public class NutritionFacts_Bad {
	
	//ml / 1회 제공량(필수)
	private final int serviceSize;
	
	//회 / 총 n회 제공량(필수)
	private final int servings;
	
	//1회 제공량당(선택)
	private final int calories;
	
	//g / 1회 제공량당(선택)
	private final int fat;
	
	//mg / 1회 제공량당(선택)
	private final int sodium;
	
	//g / 1회 제공량당(선택)
	private final int carbohydrate;
	
	public NutritionFacts_Bad(int serviceSize, int servings) {
		this(serviceSize, servings, 0);
	}
	
	public NutritionFacts_Bad(int serviceSize, int servings, int calories) {
		this(serviceSize, servings, calories, 0);
	}
	
	public NutritionFacts_Bad(int serviceSize, int servings, int calories, int fat) {
		this(serviceSize, servings, calories, fat, 0);
	}
	
	public NutritionFacts_Bad(int serviceSize, int servings, int calories, int fat, int sodium) {
		this(serviceSize, servings, calories, fat, sodium, 0);
	}
	
	public NutritionFacts_Bad(int serviceSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
		this.serviceSize = serviceSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}
	
}
