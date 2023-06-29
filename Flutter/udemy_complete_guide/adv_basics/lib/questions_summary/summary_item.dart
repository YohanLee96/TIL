import 'package:adv_basics/questions_summary/question_identifier.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class SummaryItem extends StatelessWidget {
  const SummaryItem(this.data, {super.key});

  final Map<String, Object> data;

  @override
  Widget build(BuildContext context) {
    final bool isAnswer = data['user_answer'] == data['correct_answer'];
    return Padding(
      padding: const EdgeInsets.symmetric(
        vertical: 8,
      ),
      child: Row(
        //주축은 수평. 횡축은 수직. 수평으로 리니어하게 정렬.
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          QuerstionIdentifier(
              questionIndex: data['question_index'] as int, isAnswer: isAnswer),
          const SizedBox(width: 20),
          //해당 위젯을 사용함으로써 행 위젯의 최대 너비, 높이를 최대 화면 너비, 높이로 맞출 수 있다.
          Expanded(
            child: Column(
              //왼쪽 정렬
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  data['question'] as String,
                  style: GoogleFonts.lato(
                      color: Colors.white,
                      fontSize: 16,
                      fontWeight: FontWeight.bold),
                ),
                const SizedBox(height: 5),
                Text(
                  data['user_answer'] as String,
                  style: const TextStyle(
                    color: Color.fromARGB(255, 202, 171, 252)
                  ),
                ),
                Text(
                  data['correct_answer'] as String,
                  style: const TextStyle(
                    color: Color.fromARGB(255, 181, 254, 246)
                  ),
                ),
              ],
            ),
          )
        ],
      ),
    );
  }
}
