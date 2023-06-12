import 'package:flutter/material.dart';

class StyledText extends StatelessWidget {

  // const StyledText(String text, {super.key}): text = text;

  const StyledText(this.text, {super.key});

  //final을 붙히면 const 생성자 사용가능.
  final String text;

  @override
  Widget build(BuildContext context) {
    return Text(
      text,
      style: const TextStyle(
          color: Colors.white,
          fontSize: 28
      ),
    );
  }

}
