import 'package:expense_tracker_app/widgets/expenses_list/expenses.dart';
import 'package:flutter/material.dart';

var kColorScheme =
    ColorScheme.fromSeed(seedColor: const Color.fromARGB(255, 96, 59, 181));

//다크 테마
var kDarkColorScheme = ColorScheme.fromSeed(
  brightness: Brightness.dark,
  seedColor: const Color.fromARGB(255, 5, 99, 125),
);

void main() {
  runApp(
    MaterialApp(
      darkTheme: ThemeData.dark().copyWith(
        useMaterial3: true,
        colorScheme: kDarkColorScheme,
        cardTheme: const CardTheme().copyWith(
          color: kDarkColorScheme.secondaryContainer,
          //Card 위젯의 기본 마진도 변경할 수 있다.
          margin: const EdgeInsets.symmetric(
            horizontal: 16,
            vertical: 8,
          ),
        ),
        elevatedButtonTheme: ElevatedButtonThemeData(
          style: ElevatedButton.styleFrom(
            backgroundColor: kDarkColorScheme.primaryContainer,
            foregroundColor: kDarkColorScheme.onPrimaryContainer,
          ),
        ),
      ),
      //copyWith() -> 필요한속성만 재사용하기 위해 사용.
      theme: ThemeData().copyWith(
        //머터리얼 앱의 스킨을 자유자재로 컨트롤할 수 있는 옵션이 있다.
        useMaterial3: true,
        colorScheme: kColorScheme,
        appBarTheme: const AppBarTheme().copyWith(
            backgroundColor: kColorScheme.onPrimaryContainer,
            foregroundColor: kColorScheme.primaryContainer),
        cardTheme: const CardTheme().copyWith(
          color: kColorScheme.secondaryContainer,
          //Card 위젯의 기본 마진도 변경할 수 있다.
          margin: const EdgeInsets.symmetric(
            horizontal: 16,
            vertical: 8,
          ),
        ),
        elevatedButtonTheme: ElevatedButtonThemeData(
          style: ElevatedButton.styleFrom(
              backgroundColor: kColorScheme.primaryContainer),
        ),
        /**
         * textTheme을 직접 호출하면 일부 TextTheme의 일부속성만 복사 및 수정할 수 있지만
         * ThemeData를 직접 복사한 후 그안에서 textTheme을 호출하게 된다면 TextTheme의 일부속성
         * 외에 다른 속성들 또한 일관성있게 수정가능 하므로, ThemeData()를 호출하여 카피한다.
         */
        textTheme: ThemeData().textTheme.copyWith(
              titleLarge: TextStyle(
                fontWeight: FontWeight.bold,
                color: kColorScheme.onSecondaryContainer,
                fontSize: 16,
              ),
            ),
      ),
      themeMode: ThemeMode.dark,
      home: const Expenses(),
    ),
  );
}
