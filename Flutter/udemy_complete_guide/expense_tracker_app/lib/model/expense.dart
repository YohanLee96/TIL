import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:uuid/uuid.dart';

enum Category { food, travel, leisure, work }

const categoryIcons = {
  Category.food: Icons.lunch_dining,
  Category.travel: Icons.flight_takeoff,
  Category.leisure: Icons.movie,
  Category.work: Icons.work,
};


final formatter = DateFormat.yMd();
const uuid = Uuid();

class Expense {
  Expense({
    required this.title,
    required this.amount,
    required this.date,
    required this.category,
  }) : id = uuid.v4(); //id는 기본값 할당.

  final String id;
  final String title;
  final double amount;
  final DateTime date;
  final Category category;

  //Dart에서 제공하는 Getter 메소드
  String get formattedDate {
    return formatter.format(date);
  }
}
