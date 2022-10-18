## static 함수와 변수
코틀린에는 ```static```키워드가 존재하지 않는다. 대신 **```companion object``` 키워드를 사용하여, 아래와 같이 정적 변수 및 메소드를 만들 수 있다.**  
또한 변수에 ```const```키워드를 추가한다면 **컴파일 시에 변수가 할당되므로,** 내부 블록내에서도 변경이 불가하다. 
```kotlin
fun main() {
    val person = Person.newBaby("이요한")
    val newBaby = Person.newBaby()
}

class Person private constructor(
    var name : String,
    var age : Int
){
    companion object {
        private const val MIN_AGE = 1
        fun newBaby(name : String) : Person {
            return Person("이요한", MIN_AGE)
        }
    }
}
```
코틀린에서는 static대용인 ```conpanion object``` 또한 인터페이스를 상속 받을 수 있다!!  

```kotlin
class Person private constructor(
    var name : String,
    var age : Int
){
    companion object  Factory : Log {
        private const val MIN_AGE = 1
        fun newBaby(name : String) : Person {
            return Person("이요한", MIN_AGE)
        }

        override fun log() {
            TODO("Not yet implemented")
        }
    }
}
```
**자바에서 코틀린의 ```companion object```fmf 사용할려면 ```@JvmStatic``` 어노테이션을 붙여야 한다!**
```kotlin
 companion object  Factory : Log {
        private const val MIN_AGE = 1
        @JvmStatic //자바에서 해당 함수를 사용하기위해 필요!!
        fun newBaby(name : String) : Person {
            return Person("이요한", MIN_AGE)
        }

        override fun log() {
            TODO("Not yet implemented")
        }
    }
```
코틀린에서 싱글톤 객체를 만드는 방법은 상당히 간단하다. ```object```키워드 사용.
```kotlin
fun main() {
    println(Singleton.a)
    Singleton.a += 10 //변경 가능.
}

object Singleton {
    var a : Int = 0
}
```
---
## 익명 클래스
익명 클래스를 사용하는 방법또한 자바와 코틀린은 아래와같이 다르다.  
[```object``` : 인터페이스명]으로 익명 메소드를 구현한다. 
```java
//Java
public class Lec12Main {

    public static void main(String[] args) {
        JavaPerson javaPerson = JavaPerson.newBaby("ABC");
        moveSomething(new Movable() {
            @Override
            public void move() {

            }

            @Override
            public void fly() {

            }
        });
    }

    private static void moveSomething(Movable movable) {
        movable.move();
        movable.fly();
    }
    
}
```

```kotlin
fun main () {
    moveSomething(object  : Movable{ //object 키워드를 통해 인터페이스를 직접 구현.
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }

    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}
```