package com.effective.ch02.Item1;



/**
 * Created by Yohan lee
 * Created on 2021-09-26.
 * 프로그램 언어 한글번역 프로그램.
 * 해당 Class를 이용하여 정적 팩토리 메소드의 장점을 설명.
 *
 **/
public class ProgramLanguage {
	
	/**
	 * 단점
	 * 정적 팩토리 메소드(static)만 제공한다면..
	 * 1. 상속을통한 하위클래스를 만들 수 없다.
	 * 2. new 키워드를 통해 생성할 수 없으니, 개발자가 정적팩토리메소드명을 확인하여 인스턴스화 해야한다.
	 */
	
	/**
	 * 1. 정적팩토리메소드는 생성자와 달리 이름을 정할 수 있다.
	 * 2. 호출될 때마다 인스턴스화 안해도 된다.
	 * (새로 생성한 인스턴스를 캐싱하여 재활용하는 방식으로 비용절감 가능.)
	 */
	public static Language ofJava() {
		
		// 3. 반환 타입의 하위 타입 객체를 반활 할 수 있는 능력이 있다.
		return new Java();
	}
	
	public static Language ofJava(int version) {
		return new JavaWithVersion(version);
	}
	
	private ProgramLanguage() {}
}
