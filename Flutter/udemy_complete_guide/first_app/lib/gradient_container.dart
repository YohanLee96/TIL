import 'package:first_app/dice_roller.dart';
import 'package:flutter/material.dart';

//final은 컴파일 시점에 타입이 정해질 수 있으면 사용할 수 있다.
final getAlignment = GradientContainer.getAlignment();
//const는 함수가아닌 상수값만 지정할 수 있다.
const getAlignment2 = Alignment.bottomRight;
var startAlignment = Alignment.topLeft;
var endAlignment = Alignment.bottomRight;
Alignment? nullAlignment; //타입의 nullable, notNull 유형 선택가능.

//이 부모위젯은 상태가 바뀌지 않는 위젯이므로, UI를 동적으로 렌더링할 수 없다.
class GradientContainer extends StatelessWidget {
  //방법1
  // const GradientContainer({super.key, required this.colors});
  //방법2
  const GradientContainer(this.color1, this.color2, {super.key});

  //다중생성자(정적 팩토리 메소드 사용 가능)
  const GradientContainer.purple({super.key})
      : color1 = Colors.deepPurple,
        color2 = Colors.indigo;
  final Color color1;
  final Color color2;

  // final List<Color> colors;

  @override
  Widget build(BuildContext context) {
    nullAlignment = Alignment.center;
    return Container(
      decoration: BoxDecoration(
        //메모리상 재사용을 위해 const 선언.
        gradient: LinearGradient(
          //색조합을 통해 그라데이션 넣는법
          colors: [color1, color2],
          begin: startAlignment,
          end: endAlignment,
        ),
      ),
      child: const Center(
        // child: StyledText('Hello World'),
        child: DiceRoller(),
      ),
    );
  }

  static getAlignment() {}
}
