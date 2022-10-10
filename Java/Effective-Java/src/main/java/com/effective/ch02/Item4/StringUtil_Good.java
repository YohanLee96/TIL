package com.effective.ch02.Item4;

/**
 * Created by Yohan lee
 * Created on 2021-11-15.
 **/
public class StringUtil_Good {
	
	/**
	 * 생성자를 private화 함으로써, 사용자가 인스턴스화하는 것을 막을 수 있다.
	 */
	private StringUtil_Good() {
		//클래스 안에서 실수로라도 생성자를 호출할 수 없도록, 인스턴스화 시, AssertionError를 명시적으로 throw 한다.
		throw new AssertionError();
	}
	
	public static String toPhoneNumberFormat(String phoneNumber) {
		if(phoneNumber.isBlank()) {
			return "";
		}
		
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		return phoneNumber.replaceAll(regEx, "$1-$2-$3");
	}
	
}
