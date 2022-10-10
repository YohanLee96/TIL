package com.effective.ch02.Item3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Created by Yohan lee
 * Created on 2021-10-26.
 * private 생성자나 열거 타입으로 싱글턴임을 보증하라.
 **/
public class Item3Main {
	
	public static void main(String[] args) {
		/**
		 * 싱글턴을 만드는 첫번째 방법
		 * 인스턴스를 접근할 수 있는 public static 필드를 final 필드로 제공한다.
		 */
		//최초 호출 시, 생성됨.
		Elvis_Bad badInst1 = Elvis_Bad.INSTANCE;
		System.out.println("badInst1 hashCode : " + badInst1.hashCode());
		//2번째 호출에서는 생성되지 않고 이미 생성된 인스턴스를 반환.(instance1과 주소값 동일)
		Elvis_Bad badInst2 = Elvis_Bad.INSTANCE;
		System.out.println("badInst2 hashCode : " + badInst2.hashCode());
		
		/**
		 * 허나, AccessibleObject.setAccessible 메소드를 통해, private 생성자를 호출할 수 있는 단점이 있다.
		 * (부울조건을 true로 줌으로써, private으로 선언된 생성자에 접근가능.)
		 */
		Constructor<?> badConstructor = Elvis_Bad.class.getDeclaredConstructors()[0];
		badConstructor.setAccessible(true);
		
		try {
			Elvis_Bad badInst3 = (Elvis_Bad) badConstructor.newInstance();
			//참조한 주소값이 변경됨.
			System.out.println("badInst3 hashCode : " + badInst3.hashCode());
		}  catch (Exception e) {
			e.printStackTrace();;
		}
		
		
		/**
		 * 싱글턴을 만드는 두번째 방법
		 * 인스턴스를 제공받을 수 있는 메소드를 정적 팩토리 메소드로 제공한다.
		 * 장점
		 * 1. 해당 클래스가 싱글턴임을 개발자가 첫번째 방법보다 쉽게 알 수 있다.
		 * 2. 정적 팩토리 메소드를 제네릭 싱글턴 팩토리 메소드로 만들 수 있다.
		 ** 제네릭 싱글톤 팩토리 : 불변 객체를 여러 타입으로 활용할 수 있게 만들어야 될 때 사용.(Item30 참조)
		 * 3. 정적 팩토리 메소드 참조를 공급자로 사용할 수 있다.
		 ** 공급자? Elvis_Good.getInstance() -> Supplier<Elvis_good> (Item 43,44 참조)
		 */
		
		Elvis_Good goodInst1 = Elvis_Good.getInstance();
		System.out.println("goodInst1 hashCode : " + goodInst1.hashCode());
		Elvis_Good goodInst2 = Elvis_Good.getInstance();
		System.out.println("goodInst2 hashCode : " + goodInst2.hashCode());
		
		Constructor<?> goodConstructor = Elvis_Good.class.getDeclaredConstructors()[0];
		goodConstructor.setAccessible(true);
		try {
			Elvis_Good goodInst3 = (Elvis_Good) goodConstructor.newInstance(); //Exception 발생.
			System.out.println("goodInst3 hashCode : " + goodInst3.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * 싱글턴 클래스를 직렬화 후, 역직렬화 할 때마다, 새로운 인스턴스가 생성될 변수가 있다.
		 */
		Elvis_Bad badInst4 = Elvis_Bad.INSTANCE;
		System.out.println("badInst4 hashCode : " + badInst4.hashCode());
		
		try {
			//직렬화
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("item3.Serialization"));
			oos.writeObject(badInst4);
			oos.close();
			
			//역직렬화
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("item3.Serialization"));
			Elvis_Bad badInst5 = (Elvis_Bad) ois.readObject();
			ois.close();
			//새로운 인스턴스가 만들어지므로, hashCode가 다름.
			System.out.println("badInst5 hashCode : " + badInst5.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * 직렬화/역직렬화 시에도, 싱글턴임을 보장하기 위해 readReslove메소드를 제공한다.
		 */
		
		Elvis_Good goodInst4 = Elvis_Good.getInstance();
		System.out.println("goodInst4 hashCode : " + goodInst4.hashCode());
		
		try {
			//직렬화
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("item3.Serialization"));
			oos.writeObject(goodInst4);
			oos.close();
			
			//역직렬화
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("item3.Serialization"));
			Elvis_Good goodInst5 = (Elvis_Good) ois.readObject();
			ois.close();
			//readResolve()메소드로 인해 처음 생성된 인스턴스가 반환되기 때문에, hashCode가 같다.
			System.out.println("goodInst5 hashCode : " + goodInst5.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * 제일 좋은 방법은 원소가 하나 뿐인 Enum으로 만드는 것이다.
		 * 구현방법이 제일 간단하며, 직렬화/역직렬화 시에 생기는 이슈와 리플렉션 이슈도 모두 해결된다.
		 */
		
		Elvis_Enum enumInst1 = Elvis_Enum.INSTANCE;
		Elvis_Enum enumInst2 = Elvis_Enum.INSTANCE;
		System.out.println("enumInst1 hashCode : " + enumInst1.hashCode());
		System.out.println("enumInst2 hashCode : " + enumInst2.hashCode());
		
	}
}
