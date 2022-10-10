package com.effective.ch02.Item2.exam;

import lombok.Getter;

import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Yohan lee
 * Created on 2021-10-23.
 * 피자 추상클래스 - 앞으로 피자를 구울경우, 이클래스를 상속하여 굽는다.
 **/

@Getter
public abstract class Pizza {
	
	public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
	
	protected final Set<Topping> toppings;
	
	// 하위 클래스의 Builder를 반환하기 위해 하위타입을 제네릭으로 지정.(공변 반환 타이핑)ㅏ
	abstract static class Builder<T extends Builder<T>> {
		/**
		 * EnumSet 메소드설명
		 * ** EnumSet.noneOf(Topping.class) Topping이라는 Enum을 다루는 빈 Set을 반환
		 * EnumSet.noneOf <-> EnumSet.allOf = Topping이라는 Enum의 값을 모두담은 Set을 반환
		 */
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping) {
			toppings.add(topping);
			return self();
		}
		
		abstract Pizza build();
		
		/**
		 * 셀프 타입 관용구(simulated self-type)
		 * 하위 클래스는 이 메소드를 재정의하여, this를 반환해야한다.
		 * 하위클래스에서 형변환을 하지 않고, 메소드 체이닝을 지원하기위해 추가.
		 */
		protected abstract T self();
	}
	
	Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
	
}
