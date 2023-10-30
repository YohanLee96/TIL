import 'package:chat_app/widgets/chat_messages.dart';
import 'package:chat_app/widgets/new_message.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:firebase_messaging/firebase_messaging.dart';
import 'package:flutter/material.dart';

class ChatScreen extends StatefulWidget {
  const ChatScreen({super.key});

  @override
  State<StatefulWidget> createState()  => _ChatScreenState();
}

class _ChatScreenState extends State<ChatScreen> {

  void setupPushNoti() async {
    final fcm = FirebaseMessaging.instance;
    //권한 허가 요청.
    await fcm.requestPermission();
    final fcmToken = await fcm.getToken();
    print(fcmToken);
    fcm.subscribeToTopic('chat');
  }


  @override
  void initState() {
    super.initState();
    setupPushNoti();
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('플러터 채팅'),
        actions: [
          IconButton(
              onPressed: () {
                FirebaseAuth.instance.signOut();
              },
              icon: Icon(
                Icons.exit_to_app,
                color: Theme.of(context).colorScheme.primary,
              ))
        ],
      ),
      body: const Column(
        children: [
          Expanded(
            child: ChatMessages(),
          ),
          NewMessage()
        ],
      ),
    );
  }
}
