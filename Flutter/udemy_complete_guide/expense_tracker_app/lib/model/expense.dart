import 'package:uuid/uuid.dart';

class Expense {
  Expense(
      {required this.id,
      required this.title,
      required this.amount,
      required this.date});
  
  final Uuid id;
  final String title;
  final double amount;
  final DateTime date;
}
