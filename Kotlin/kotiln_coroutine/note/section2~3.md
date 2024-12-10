### runBlocking
- 하나의 코루틴 생성함수.
- 함수를 호출한 스레드를 사용해 실행되는 코루틴을 만듬.
- `runBlokcing` 코루틴이 종료될때 스레드 점유 해제. 
### Debug
- VM옵션에 `-Dkotlinx.coroutines.debug`을 주면 로그를 찍을때 **어떤 코루틴이 점유하고 있는지 확인 가능.**
- 인텔리제이에서 디버그 기능을 통해 코루틴을 좀더 디테일하게 디버깅 할 수 있음.