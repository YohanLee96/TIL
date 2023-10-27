
import 'package:flutter/material.dart';

class SplashScreen extends StatelessWidget {

  const SplashScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('플러터 채팅'),
      ),
      body: const Center(
        child: Text('로그인 성공!'),
      ),
    );
  }
}
