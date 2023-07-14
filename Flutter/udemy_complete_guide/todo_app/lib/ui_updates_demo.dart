import 'package:flutter/material.dart';

import 'demo_buttons.dart';

class UIUpdatesDemo extends StatelessWidget {
  const UIUpdatesDemo({super.key});

  @override
  Widget build(BuildContext context) {
    /**
     * 상태관리가 필요한 위젯을 컴포넌트로 빼고 해당 메인 위젯을 비상태 위젯으로 만든다면
     * 버튼 클릭(DemoButtons) 시, 상태관리가 필요한 위젯만 재 렌더링 되고, 메인 위젯은 다시 렌더링되지 않는다.
     */
    return const Padding(
      padding: EdgeInsets.all(8.0),
      child: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Text(
              'Every Flutter developer should have a basic understanding of Flutter\'s internals!',
              textAlign: TextAlign.center,
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 16),
            Text(
              'Do you understand how Flutter updates UIs?',
              textAlign: TextAlign.center,
            ),
            SizedBox(height: 24),
            DemoButtons()
          ],
        ),
      ),
    );
  }
}
