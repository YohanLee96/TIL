package com.effective.ch02.Item3;

import java.io.Serializable;

/**
 * Created by Yohan lee
 * Created on 2021-10-26.
 **/

public class Elvis_Bad implements Serializable {
	
	/**
	 * static final 키워드를 붙혀줌으로서,
	 * 해당 변수가 메모리에 올라갈때 딱한번만 초기화하여 사용할 수 있으며, 불변이다.
 	 */
	public static final Elvis_Bad INSTANCE = new Elvis_Bad();
	
	//임의로 인스턴스화하는것을 막기위해 생성자를 private으로 변경.
	private Elvis_Bad() {
		System.out.println("Create Elvis_Bad");
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
