### CoroutineDispatcher
- 정의: 코루틴을 스레드로 보내 실행시키는 객체.
- 코루틴을 스레드풀에 보내는 역할을함.
- 작업대기열 개념이 존재.
- 코루틴의 실행을 제어함.
- newSingleThreadContext() : 단일 스레드 디스페처를 생성함(Code3-1.kt 참조)
- newFixedThreadPoolContext() : 고정된 멀티스레드 디스페처를 생성함(Code3-2.kt 참조)
  - ** 이렇게 개발자가 임의로 디스페처를 생성하여 사용하면 협업 시, 사이드이펙트가 발생할 우려가 있음.
### 미리 정의된 CoroutineDispatcher의 종류
- Dispatchers.IO
  - I/O 작업이 빈번한 경우 사용하는 디스페처
  - 가용 스레드 수 : max(64, `JVM에서 사용할 수 있는 프로세서의 수`) -> 보통 프로세서가 64개를 넘는경우가 드물어서 보통 64개로 셋팅됨.
- Dispatchers.Default
  - CPU 사용량이 많은 작업을 처리할 때 사용하는 디스페처
  - 가용 스레드 수 : max(2, `JVM에서 사용할 수 있는 프로세서의 수`) -> 보통 프로세수로 할당.
- Dispatchers.Main
  - 메인 스레드에서의 작업을 위한 디스페처.
  - 안드로이드는 UI를 그리는 작업을 메인 스레드에서 해야하기 때문에 주로 안드로이드에서 사용.
  - 안드로이드에서만 사용가능(`implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")`를 추가해야됨)
- 모든 CoroutineDispatcher.IO와 Dispatchers.Default는 **공유 스레드풀**을 사용함.
### CoroutineDispatcher의 limitedParallelism
- Dispatchers.Default.limitedParallelism([사용 스레드 수]) > 스레드 고갈을 막기위해 사용 스레드 개수를 제한할 수 있는 옵션.
- Dispatchers.IO.limitedParallelism([사용 스레드 수])
  - Dispatchers.Default.limitedParallelism와 다른점은 공유 스레드풀내에서 별도의 집합으로 관리됨.
  - 다른작업으로부터 방해받지 않아야될 때 사용.
