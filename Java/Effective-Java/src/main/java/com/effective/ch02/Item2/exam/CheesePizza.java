package com.effective.ch02.Item2.exam;

import lombok.Getter;

import java.util.Objects;

/**
 * Created by Yohan lee
 * Created on 2021-10-23.
 * 담백한 치즈피자!
 **/

@Getter
public class CheesePizza extends Pizza {
	
	public enum Border { RICH, CHEESE_CRUST }
	
	private final boolean sauceInside;
	
	private final Border border;
	
	
	public static class Builder extends Pizza.Builder<Builder> {
		
		private boolean sauceInside = false;
		
		private Border border;
		
		public Builder sauceInside() {
			this.sauceInside = true;
			return this;
		}
		
		public Builder border(Border border) {
			this.border = border;
			return this;
		}
		
		@Override
		CheesePizza build() {
			return new CheesePizza(this);
		}
		
		@Override
		protected Builder self() {
			return this;
		}
	}
	
	
	public CheesePizza(Builder builder) {
		super(builder);
		sauceInside = builder.sauceInside;
		border = builder.border;
	}
	
}
