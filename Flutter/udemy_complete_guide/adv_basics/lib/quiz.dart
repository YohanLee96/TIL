import 'package:flutter/material.dart';
import 'package:adv_basics/start_screen.dart';
import 'package:adv_basics/questions_screen.dart';
import 'package:adv_basics/data/questions.dart';
import 'package:adv_basics/result_screen.dart';

class Quiz extends StatefulWidget {
  const Quiz({super.key});

  @override
  State<Quiz> createState() {
    return _QuizState();
  }
}

class _QuizState extends State<Quiz> {
  // ignore: slash_for_doc_comments
  /** initState()를 이용한 상태 초기화
      //initState() 함수가 실행된 이후에 바인딩되므로, 초기값은 Null이다.
      Widget? activeScreen;

      //클래스가 인스턴스화 된 이후에 바로 실행된 초기화함수 initState()
      @override
      void initState() {
      activeScreen = StartScreen(switchScreen);
      super.initState();
      }

      void switchScreen() {
      setState(() {
      //State에 변화가 있을때마다 재빌드 한다.
      activeScreen = const QuestionsScreen();
      });
      }
   **/

  List<String> selectedAnswers = [];
  var activeScreen = 'start-screen';

  void switchScreen() {
    setState(() {
      activeScreen = 'questions-screen';
    });
  }

  void chooseAnswer(String answer) {
    selectedAnswers.add(answer);
    if (selectedAnswers.length == questions.length) {
      setState(() {
        activeScreen = 'result-screen';
      });
    }
  }

  void restart() {
    setState(() {
      selectedAnswers = [];
      activeScreen = 'start-screen';
    });
  }

  @override
  Widget build(BuildContext context) {
    Widget screenWidget = StartScreen(switchScreen);
    if (activeScreen == 'questions-screen') {
      screenWidget = QuestionsScreen(
        onSelectAnswer: chooseAnswer,
      );
    }

    if (activeScreen == 'result-screen') {
      screenWidget = ResultScreen(
        chosenAnswers: selectedAnswers,
        onRestart: restart,
      );
    }

    return MaterialApp(
      home: Scaffold(
        body: Container(
            decoration: const BoxDecoration(
                gradient: LinearGradient(
              colors: [
                Color.fromARGB(255, 78, 13, 151),
                Color.fromARGB(255, 107, 15, 168),
              ],
              begin: Alignment.topLeft,
              end: Alignment.bottomRight,
            )),
            //1. initState()를 통한 상태 컨트롤 방법
            // child: activeScreen,
            //2. 문자열 기반 삼항연산자를 통해 상태 컨트롤 방법
            // child: activeScreen == 'start-screen'
            //     ? StartScreen(switchScreen)
            //     : const QuestionsScreen(),
            //3. if문을 통한 상태 컨트롤 방법
            child: screenWidget),
      ),
    );
  }
}
