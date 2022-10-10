package com.effective.ch02.Item4;

/**
 * Created by Yohan lee
 * Created on 2021-11-15.
 * 생성자가 private이 아니라면, 컴파일러가 컴파일 시 public 기본 생성자를 만들어 준다.
 * 이 때문에 해당 클래스를 인스턴스화 하여 사용해야 하는지,
 * 정적 메소드만 사용할려고 만든 유틸형 클래스인지, 헷갈려 할 수 있다.
 **/
public class StringUtil_Bad {
	
	public static String toPhoneNumberFormat(String phoneNumber) {
		if(phoneNumber.isBlank()) {
			return "";
		}
		
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		return phoneNumber.replaceAll(regEx, "$1-$2-$3");
	}
}
