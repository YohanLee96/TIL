import 'package:adv_basics/questions_summary/summary_item.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class QuestionsSummary extends StatelessWidget {
  const QuestionsSummary(this.summaryData, {super.key});

  final List<Map<String, Object>> summaryData;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 400,
      child: SingleChildScrollView(
        //크기를 고정시키고 스크롤을 생성한다.
        child: Column(
          children: summaryData
              .map((data) => SummaryItem(data))
              .toList(),
        ),
      ),
    );
  }
}
