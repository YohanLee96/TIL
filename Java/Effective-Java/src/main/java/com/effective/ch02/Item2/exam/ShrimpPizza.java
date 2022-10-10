package com.effective.ch02.Item2.exam;

import lombok.Getter;

import java.util.Objects;

/**
 * Created by Yohan lee
 * Created on 2021-10-23.
 * 개꿀 새우피자
 **/

@Getter
public class ShrimpPizza extends Pizza {
	
	public enum Size { SMALL, MEDIUM, LARGE }
	
	private final Size size;
	
	public static class Builder extends Pizza.Builder<Builder> {
		
		private final Size size;
		
		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}
		
		@Override
		ShrimpPizza build() {
			return new ShrimpPizza(this);
		}
		
		@Override
		protected Builder self() {
			return this;
		}
	}
	
	ShrimpPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}
	
	
	
}
