import 'package:flutter/material.dart';
import 'package:meals/models/meal.dart';
import 'package:meals/widgets/meal_item.dart';

import 'meal_details.dart';

class MealsScreen extends StatelessWidget {
  const MealsScreen({
    super.key,
    required this.meals,
    required this.title,
  });

  final String title;
  final List<Meal> meals;

  void selectMeal(BuildContext context, Meal meal) {
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (ctx) => MealDetailsScreen(meal: meal),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    Widget content = ListView.builder(
      itemCount: meals.length,
      itemBuilder: (ctx, index) =>
          MealItem(meal: meals[index], onSelectMeal: (meal) {
            selectMeal(context, meals[index]);
          },),
    );
    if (meals.isEmpty) {
      content = Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text(
              '음식이 존재하지 않아요!',
              style: Theme
                  .of(context)
                  .textTheme
                  .headlineLarge!
                  .copyWith(
                color: Theme
                    .of(context)
                    .colorScheme
                    .onBackground,
              ),
            ),
            const SizedBox(height: 16),
            Text(
              '다른 카테고리를 확인해보세요!',
              style: Theme
                  .of(context)
                  .textTheme
                  .bodyLarge!
                  .copyWith(color: Theme
                  .of(context)
                  .colorScheme
                  .onBackground),
            )
          ],
        ),
      );
    }
    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      body: content,
    );
  }
}
