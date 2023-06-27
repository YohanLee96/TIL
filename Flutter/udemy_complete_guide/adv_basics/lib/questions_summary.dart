import 'package:flutter/material.dart';

class QuestionsSummary extends StatelessWidget {
  const QuestionsSummary(this.summaryData, {super.key});

  final List<Map<String, Object>> summaryData;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 300,
      child: SingleChildScrollView( //크기를 고정시키고 스크롤을 생성한다.
        child: Column(
          children: summaryData.map(
            (data) {
              return Row(
                children: [
                  Text(((data['question_index'] as int) + 1).toString()),
                  //해당 위젯을 사용함으로써 행 위젯의 최대 너비, 높이를 최대 화면 너비, 높이로 맞출 수 있다.
                  Expanded(
                    child: Column(
                      children: [
                        Text(data['question'] as String),
                        const SizedBox(height: 5),
                        Text(data['user_answer'] as String),
                        Text(data['correct_answer'] as String),
                      ],
                    ),
                  )
                ],
              );
            },
          ).toList(),
        ),
      ),
    );
  }
}
