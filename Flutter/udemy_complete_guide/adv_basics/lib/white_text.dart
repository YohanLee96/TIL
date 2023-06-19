import 'package:flutter/material.dart';

class WhiteText extends StatelessWidget {
  final String data;
  final double fontSize;

  const WhiteText(this.data, {super.key, required this.fontSize});

  @override
  Widget build(BuildContext context) {
    return Text(data, style: TextStyle(color: Colors.white, fontSize: fontSize));
  }
}
