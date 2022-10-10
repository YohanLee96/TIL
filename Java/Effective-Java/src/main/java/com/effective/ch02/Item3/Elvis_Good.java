package com.effective.ch02.Item3;

import java.io.Serializable;

/**
 * Created by Yohan lee
 * Created on 2021-10-29.
 **/
public class Elvis_Good implements Serializable {
	
	private static final Elvis_Good INSTANCE = new Elvis_Good();
	
	private Elvis_Good() {
		/**
		 * 리플랙션을 통한 가짜 생성자를 방지하기 위해,
		 * 최초 이후 두번쨰로 생성자를 호출할려고 할때, Exception을 발생시킨다.
		 */
		if(INSTANCE != null) {
			throw new RuntimeException("This class is a singleton class.");
		}
		System.out.println("Create Elvis_Good");
	}
	
	public static Elvis_Good getInstance() {
		return INSTANCE;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	//직렬화/역직렬화 과정에서 새로운 인스턴스가 생성되는것을 막기위해 readResolve()메소드를 구현.
	private Object readResolve() {
		/**
		 * readObject 메소드 호출 시, 최초 생성된 인스턴스를 반환하고
		 * readObject로 인해 만들어진 객체는 가비지 컬렉터에게 맡긴다.
 		 */
		return INSTANCE;
	}
	
}
