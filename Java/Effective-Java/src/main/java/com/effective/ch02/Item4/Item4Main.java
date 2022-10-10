package com.effective.ch02.Item4;

/**
 * Created by Yohan lee
 * Created on 2021-11-15.
 * 인스턴스화를 막으려거든 private 생성자를 사용하라
 **/
public class Item4Main {
	
	public static void main(String[] args) {
		//인스턴스화 하여, 사용할 메소드는 없지만 컴파일러로 인해 기본생성자가 생성된다.
		StringUtil_Bad stringUtil = new StringUtil_Bad();
		
		//StringUtil_Good stringUtil = new StringUtil_Good(); -> 생성자가 private 이기 때문에 컴파일로 오류 발생!!
		System.out.println(StringUtil_Good.toPhoneNumberFormat("01038206915"));
	}
}
