// ignore_for_file: avoid_print

import 'package:expense_tracker_app/widgets/chart/chart.dart';
import 'package:expense_tracker_app/widgets/expenses_list/expenses_list.dart';
import 'package:expense_tracker_app/model/expense.dart';
import 'package:expense_tracker_app/widgets/new_expense.dart';
import 'package:flutter/material.dart';

class Expenses extends StatefulWidget {
  @override
  State<Expenses> createState() {
    return _ExpensesState();
  }

  const Expenses({super.key});
}

class _ExpensesState extends State<Expenses> {
  final List<Expense> _registerExpenses = [
    Expense(
      title: 'Flutter Course',
      amount: 19.99,
      date: DateTime.now(),
      category: Category.work,
    ),
    Expense(
      title: 'Cinema',
      amount: 15.69,
      date: DateTime.now(),
      category: Category.leisure,
    ),
  ];

  void _openAddExpenseOverlay() {
    showModalBottomSheet(
      //내장된 카메라의 공간을 Safe Area로 자동지정해서 레이아웃 구성 시, 자동으로 padding을 줘서 구성한다.
      useSafeArea: true,
      isScrollControlled: true, //키보드가 UI를 가리지 않도록 할려면, 해당 옵션을 true로 준다.
      context: context,
      builder: (ctx) => NewExpense(onAddExpense: _addExpense),
    );
  }

  void _addExpense(Expense expense) {
    setState(() {
      _registerExpenses.add(expense);
    });
  }

  void _removeExpense(Expense expense) {
    //삭제된 아이템의 인덱스
    final expenseIndex = _registerExpenses.indexOf(expense);
    setState(() {
      _registerExpenses.remove(expense);
    });
    ScaffoldMessenger.of(context).clearSnackBars();
    //아이템 삭제를 롤백하기 위한 로직
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        //스낵바를 3초동안 유지한다.
        duration: const Duration(seconds: 3),
        content: const Text('Expense deleted.'),
        //스낵바의 액션을 정의한다.
        action: SnackBarAction(
          label: 'Undo',
          onPressed: () {
            setState(() {
              //이전에 삭제된 인덱승 위치에 다시 삽입한다.
              _registerExpenses.insert(expenseIndex, expense);
            });
          },
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final width = MediaQuery.of(context).size.width;
    final height = MediaQuery.of(context).size.height;
    Widget mainContent = const Center(
      child: Text('No Expenses found. Start adding some!'),
    );
    if (_registerExpenses.isNotEmpty) {
      mainContent = ExpensesList(
        expenses: _registerExpenses,
        onRemoveExpense: _removeExpense,
      );
    }

    return Scaffold(
      appBar: AppBar(
        title: const Text('Flutter ExpenseTracker'),
        actions: [
          IconButton(
            onPressed: _openAddExpenseOverlay,
            icon: const Icon(Icons.add),
          )
        ],
      ),
      body: width < 600
          ? Column(
              children: [
                Chart(expenses: _registerExpenses),
                Expanded(child: mainContent),
              ],
            )
          : Row(
              children: [
                // Expanded -> 위젯 크기를 제한하기 위해 사용.
                Expanded(child: Chart(expenses: _registerExpenses)),
                Expanded(child: mainContent),
              ],
            ),
    );
  }
}

class ExpenseBucket {
  const ExpenseBucket({
    required this.category,
    required this.expenses,
  });

  final Category category;
  final List<Expense> expenses;

  ExpenseBucket.forCategory(List<Expense> expenses, this.category)
      : expenses =
            expenses.where((expense) => expense.category == category).toList();

  double get totalExpenses {
    double sum = 0;
    for (final expense in expenses) {
      sum += expense.amount;
    }

    return sum;
  }
}
