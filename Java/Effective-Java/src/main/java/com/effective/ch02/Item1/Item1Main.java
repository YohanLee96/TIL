package com.effective.ch02.Item1;

/**
 * Created by Yohan lee
 * Created on 2021-09-26.
 * 생성자 대신 정적 팩토리 메소드를 고려하라
 **/
public class Item1Main {
	
	public static void main(String[] args) {
		System.out.println("Java 번역 -> " + ProgramLanguage.ofJava().getValue());
		//4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
		System.out.println("Java8 번역 -> " + ProgramLanguage.ofJava(8).getValue());
	}
}
