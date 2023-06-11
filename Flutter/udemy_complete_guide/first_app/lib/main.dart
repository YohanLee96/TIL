//runApp()에 대한 의존성
import 'package:flutter/material.dart';

import 'gradient_container.dart';

void main() {
  /**
   * 앱을 실행하는 메인 함수
   * 앱을 실행할려면 위젯 트리가 필요하다.
   * const를 쓰면 중복을 방지(재할당을 통한 메모리 재할당행위가 필요없으므로, 메모리를 효율적으로 사용가능.)
   * 할 수 있다. -> const를 씀으로써 코드적으로 메모리 재할당을 방지할 수 있어서 좋다고 하는듯?
   *
   */
  runApp(
    const MaterialApp(
      //const를 붙힐려면 하위 위젯들의 생성자가 const 생성자이어야 한다.
      home: Scaffold(
        backgroundColor: Color.fromARGB(255, 47, 5, 120),
        // or Colors.deepPurple -> 팩토리로 지정 가능.
        body: GradientContainer(),
      ),
    ), //쉼표를 쓰면 IDE에서 보기 쉽게 줄넘김을 해준다.
  );
}

