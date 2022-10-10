package com.effective.ch02.Item2;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Yohan lee
 * Created on 2021-09-27.
 * 식품 포장의 영양정보를 포함하는 POJO 객체.
 * Java Beans 패턴 사용 -> 필드마다 Setter 메소드 부여 방식
 **/

@Getter
@Setter
public class NutritionFacts_Bad2 {
	
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
	
	public NutritionFacts_Bad2() {}
}
