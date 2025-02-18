### async-await을 사용하여 코루틴 결과 수신
- async 코루틴 빌더 호출 시, 코루틴 생성 후 Deferred<T> 타입의 객체를 반환.
- Job과 같은 코루틴 추상 객체지만, **코루틴으로부터 생성된 결과값을 감싸는 기능을 추가로 가짐.**
- async와 launch의 차이점 > 제네릭 타입으로 결과타입이 정의됨.
- Deferred 객체는 미래시점에 결과값이 반환될 수 있음을 표현하는 객체.
- Deferred 객체는 await 함수를 통해 결과값을 수신할 수 있음.
  - await함수를 호출한 코루틴은 일시 중단됨 > 결과값이 반환되면 다시 재개.
### Deferred Job
- launch 함수는 Job 객체를 반환.
- async 함수는 Deferred 객체를 반환.
- Deferred 객체는 **Job의 서브타입**이며, 결과값 수신을 위해 단순히 몇가지 함수만 추가된 인터페이스임.
### awaitAll을 통해 복수의 코루틴 결과 수신
- 여러 비동기 작업으로부터 결과값을 반환받아 병합해야되는 경우가 생김 > 이때 복수의 코루틴을 생성하여 취합해야됨.
- awaitAll 함수를 사용하면 복수의 코루틴 결과값을 받을 수 있음.
### withContext 함수를 사용한 결과 수신
- CoroutineDispatcher를 사용해 실행 스레드를 전환하고, 람다 코드를 실행후 결과값 반환하는 함수.
- async와의 차이점 > 기존코루틴을 유지하며 **새로운 코루틴을 생성하지 않고, 스레드만 바뀜.**
