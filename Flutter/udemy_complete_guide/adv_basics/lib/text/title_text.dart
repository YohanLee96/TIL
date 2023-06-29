import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class TitleText extends StatelessWidget {

  const TitleText(this.text, {super.key});

  final String text;

  @override
  Widget build(BuildContext context) {
    return Text(
      text,
      style: GoogleFonts.lato(
        color: const Color.fromARGB(255, 201, 153, 251),
        fontSize: 24,
        fontWeight: FontWeight.bold,

      ),
      textAlign: TextAlign.center,
    );
  }

}