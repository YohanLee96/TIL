import 'package:flutter/material.dart';

//순번 UI. 정답유무에 따라 색상이 바뀐다.
class QuerstionIdentifier extends StatelessWidget {
  const QuerstionIdentifier(
      {super.key, required this.questionIndex, required this.isAnswer});

  //퀴즈 순번
  final int questionIndex;

  //정답을 맞췄는지..
  final bool isAnswer;

  int get questionNumber {
    return questionIndex + 1;
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 30,
      height: 30,
      alignment: Alignment.center,
      //텍스트를 박스로 Wrapping 한다.
      decoration: BoxDecoration(
          color: isAnswer
              ? const Color.fromARGB(255, 150, 198, 241)
              : const Color.fromARGB(255, 249, 133, 241),
          //박스를 둥글게 만든다.
          borderRadius: BorderRadius.circular(100)),
      child: Text(
        questionNumber.toString(),
        style: const TextStyle(
          fontWeight: FontWeight.bold,
          color: Color.fromARGB(255, 22, 2, 56),
        ),
      ),
    );
  }
}
