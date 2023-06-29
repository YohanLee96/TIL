import 'package:adv_basics/text/title_text.dart';
import 'package:flutter/material.dart';

class StartScreen extends StatelessWidget {
  const StartScreen(this.startQuiz, {super.key});

  //함수를 변수로 받아들일 수 있다. 아래는 반환값이 없는 함수에 대한 변수.
  final void Function() startQuiz;

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Image.asset(
            'assets/images/quiz-logo.png',
            width: 300,
            //직접 RGB를 통해 색깔의 투명도를 부여하자.
            color: const Color.fromARGB(150, 255, 255, 255),
          ),
          // Opactivy객체를 직접적으로 쓰는건 지양해야한다.(특이 케이스외에 쓸데없이 코드가 복잡해지는 경우가있기때문인듯..)
          // Opacity(
          //   opacity: 0.5,
          //   child: Image.asset(
          //     'assets/images/quiz-logo.png',
          //     width: 300,
          //   ),
          // ),
          const SizedBox(height: 80),
          const TitleText('Learn Flutter the fun way!'),
          const SizedBox(height: 30),
          OutlinedButton.icon(
            onPressed: startQuiz,
            style: OutlinedButton.styleFrom(
              foregroundColor: Colors.white,
            ),
            icon: const Icon(Icons.arrow_right_alt),
            label: const Text('Start Quiz'),
          )
        ],
      ),
    );
  }
}
