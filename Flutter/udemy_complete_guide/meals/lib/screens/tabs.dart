import 'package:flutter/material.dart';
import 'package:meals/screens/categories.dart';
import 'package:meals/screens/meals.dart';
import 'package:meals/widgets/main_drawer.dart';

import '../models/meal.dart';

class TabsScreen extends StatefulWidget {
  const TabsScreen({super.key});

  @override
  State<TabsScreen> createState() {
    return _TabsScreenState();
  }
}

class _TabsScreenState extends State<TabsScreen> {
  int _selectedPageIndex = 0;
  final List<Meal> _favoriteMeals = [];

  void _toggleMealFavoriteStatus(Meal meal) {
    final bool isExisting = _favoriteMeals.contains(meal);
    if (isExisting) {
      setState(() {
        _favoriteMeals.remove(meal);
      });
      _showInfoMessage('${meal.title}이(가) 즐겨찾기에서 해제되었습니다.');
    } else {
      setState(() {
        _favoriteMeals.add(meal);
      });
      _showInfoMessage('${meal.title}이(가) 즐겨찾기에 등록되었습니다.');
    }
  }

  void _showInfoMessage(String message) {
    //기존에 표출된 스낵바 제거.
    ScaffoldMessenger.of(context).clearSnackBars();
    //새롭게 스낵바 표출.
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(
        content: Text(message),
      ),
    );
  }

  void _selectPage(int index) {
    setState(() {
      _selectedPageIndex = index;
    });
  }

  void _setScreen(String identifier) {
    if(identifier == 'filters') {

    } else {
      Navigator.of(context).pop();
    }
  }

  @override
  Widget build(BuildContext context) {
    Widget activePage = CategoriesScreen(
      selectFavorite: _toggleMealFavoriteStatus,
    );
    var activePageTitle = '카테고리';
    if (_selectedPageIndex == 1) {
      activePageTitle = '즐겨찾기';
      activePage = MealsScreen(
        meals: _favoriteMeals,
        selectFavorite: (meal) {
          _toggleMealFavoriteStatus(meal);
        },
      );
    }

    return Scaffold(
      appBar: AppBar(
        title: Text(activePageTitle),
      ),
      //숨김 가능한 사이드바
      drawer: MainDrawer(onSelectScreen: _setScreen,),
      body: activePage,
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedPageIndex,
        onTap: (index) {
          _selectPage(index);
        },
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.set_meal),
            label: '카테고리',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.star),
            label: '즐겨찾기',
          ),
        ],
      ),
    );
  }
}
