### Nullable, Not Null
코틀린에서는 null이 가능한 타입과 불가능한 타입을 완전히 다르게 취급한다.  
아래코드를 예시를 들면 str이 nullable인데, **반환값이 nullable이 아니므로**, 컴파일 에러가 난다.
```kotlin
fun startWith(str: String?): Boolean {
    return str.startsWith("A");  //컴파일 에러
}
```
### Safe Call
str이 null이라면 그냥 null반환. 아니라면 .length실행.
```kotlin
val str: String? = null;
println(str?.length);
```
### Elvis 연산자
삼항연산자와 비슷함. str이 null이면 **?:뒤에 변수 출력.** 아니라면 str.length 출력. 
```kotlin
    val str: String? = null;
    println(str?.length ?:0);
```

### Nullable변수를 Not Null 변수같이 사용하고 싶을 경우,
"!!"를 붙힐 경우, Safe Call을 사용할 필요 없다. **주의점은 진짜 null이 들어왔을 경우, NPE가 발생한다.**
```kotlin
fun startWith(str: String?): Boolean {
    return str!!.startsWith("A");
}
```

### Java코드를 Kotlin에서 사용할 경우,
**org.jetbrains.annotations.~** 패키지를 통해 Null여부를 핸들링해서 컴파일에러를 보완할 수 있다.
