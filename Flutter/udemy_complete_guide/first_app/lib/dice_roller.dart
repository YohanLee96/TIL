import 'package:flutter/material.dart';
import 'dart:math';

class DiceRoller extends StatefulWidget {
  const DiceRoller({super.key});

  @override
  State<DiceRoller> createState() {
    return _DiceRollerState();
  }

}

final randomizer = Random();

//DiceRoller의 상태를 저장하는 데이터 클래스(언더 스코어를 붙히면, private하게 사용 가능.)
class _DiceRollerState extends State<DiceRoller> {

  var currentDiceRoll = 2;

  void rollDice() {
    var diceRoll = randomizer.nextInt(6) +1; //1~6
    setState(() {
      currentDiceRoll = diceRoll;
    });

    print('Changed Roll -> $diceRoll');

  }

  @override
  Widget build(BuildContext context) {
    //다중 위젯을 사용할땐 Column 또는 Row 사용. (Column -> 세로 정렬, Row -> 가로 정렬)
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        Image.asset(
          'assets/images/dice-$currentDiceRoll.png',
          width: 200,
        ),
        const SizedBox(height: 20),
        TextButton(
          //클릭 이벤트
          onPressed: rollDice,
          style: TextButton.styleFrom(
            // padding: const EdgeInsets.only(top: 10),
              foregroundColor: Colors.white,
              textStyle: const TextStyle(
                fontSize: 28,
              )),
          child: const Text('Roll Dice'),
        )
      ],
    );
  }

}