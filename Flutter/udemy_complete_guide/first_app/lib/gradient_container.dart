import 'package:first_app/styled_text.dart';
import 'package:flutter/material.dart';

var startAlignment = Alignment.topLeft;
var endAlignment = Alignment.bottomRight;
Alignment? nullAlignment; //타입의 nullable, notNull 유형 선택가능.

class GradientContainer extends StatelessWidget {
  const GradientContainer({super.key});

  @override
  Widget build(BuildContext context) {
    nullAlignment = Alignment.center;
    return Container(
      decoration: BoxDecoration(
        //메모리상 재사용을 위해 const 선언.
        gradient: LinearGradient(
          //색조합을 통해 그라데이션 넣는법
          colors: const [Colors.deepPurple, Colors.black26],
          begin: startAlignment,
          end: endAlignment,
        ),
      ),
      child: const Center(
        child: StyledText(),
      ),
    );
  }
}