import 'package:flutter/material.dart';
import 'package:meals/data/dummy_data.dart';
import 'package:meals/models/category.dart';
import 'package:meals/models/meal.dart';
import 'package:meals/screens/meals.dart';
import 'package:meals/widgets/category_grid_item.dart';

class CategoriesScreen extends StatelessWidget {
  const CategoriesScreen({
    super.key,
    required this.selectFavorite,
    required this.availableMeals
  });

  final void Function(Meal meal) selectFavorite;
  final List<Meal> availableMeals;

  void _selectCategory(BuildContext context, Category category) {
    List<Meal> selectedMeals = availableMeals
        .where((meal) => meal.categories.contains(category.id))
        .toList();

    //스택구조. 푸시하여 화면을 현재화면에서 다른화면을 올리는 방식? 이다.
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (ctx) => MealsScreen(
          meals: selectedMeals,
          selectFavorite: selectFavorite,
          title: category.title,
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return GridView(
      padding: const EdgeInsets.all(24),
      gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: 2,
        childAspectRatio: 3 / 2,
        crossAxisSpacing: 20,
        mainAxisSpacing: 20,
      ),
      children: [
        //map으로 순회하면서 호출할 수도 있다.
        //availableCategories.map(category) => CategoryGridItem(category: category)).toList()
        for (final category in availableCategories)
          CategoryGridItem(
            category: category,
            onSelectCategory: () {
              _selectCategory(context, category);
            },
          )
      ],
    );
  }
}
