### 코루틴 순차처리
- `join()`을 통해, 순차처리를 보증할 수 있음.
- `joinAll()`을 통해 복수의 코루틴을 병렬 실행 후, 모든 코루틴이 완료될 때까지 대기할 수 있음(Code5-2.kt 참조)
### CoroutineStart.LAZY
- 지연 코루틴 = 즉시 실행되지 않는 코루틴.
- `launch`함수의 start인자로 `CoroutineStart.LAZY`를 전달하면, 지연 코루틴 생성.
- 지연 코루틴은 `start()`함수를 통해 특정시점에 실행할 수 있음.
### 코루틴 취소
- 코루틴 실행 도중, 실행할 필요가 없다면 해당 코루틴을 즉시 취소해야됨(리소스 낭비 방지)
- `cancel()`함수를 통해 코루틴을 취소할 수 있음.
- `cancel()' 함수의 문제점
  - 코루틴을 곧바로 취소하지 않고 취소 요청만 보내는 것이기 때문에, **취소 요청을 받은 코루틴이 실제 취소되는 시점은 코루틴이 실행되는 시점에 달려있음.**
- `cancel()` 함수의 문제점을 해소할려면 `cancelAndJoin()`함수 사용. 취소가 완료될때까지 호출 코루틴 일시중단.
### 코루틴 취소 확인 시점
- `delay()` > delay()함수는 특정 시간만큼 코루틴이 **일시중단**됨. > 일시 중단 시점에 코루틴의 취소가 확인돼 취소할 수 있음.
  - 이러한 방식은 불필요하게 작업을 지연시켜 성능 저하 발생.
- `yield()` > "양보"라는 뜻으로 yield함수를 호출한 코루틴은 자신이 사용한 스레드를 양보함.
  - 양보한다 > 코루틴이 스레드 사용을 중단하고 **일시중단**함 > 스레드를 양보한후 곧바로 재개요청됨(재개 시에는 COntinuationInterceptor를 통해 재개됨)
  - 하지만 해당 방식도 불필요한 작업을 지연시키는 문제가 있음.
- `isActive` 확장 프로퍼티 사용 > 코루틴이 취소 요청되면 isActive가 false가 됨(BEST)
### 코루틴의 상태
- `New` : 생성
- `Active` : 실행중
- `Completed` : 완료
- `Cancelling` : 취소중
- `Cancelled` : 취소
- `job.isActive` : `Active` 상태일때만 true.
- `job.isCancelled` : `Cancelling` OR `Cancelled` 상태일때만 true.
- `job.isCompleted` : `Completed` OR `Cancelled` 상태일때만 true.
