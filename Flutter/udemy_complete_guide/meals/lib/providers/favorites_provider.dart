import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:meals/models/meal.dart';

class FavoriteMealsNotifier extends StateNotifier<List<Meal>> {
  FavoriteMealsNotifier() : super([]);

  bool toggleMealfavoriteStatus(Meal meal) {
    //상태를 변경하고자 할때 원본값을 수정하지말고 재할당을 해야한다.
    final mealIsfavorite = state.contains(meal);
    if (mealIsfavorite) { //이미 즐겨찾기가 되있다면 즐겨찾기 해제 이므로, where로 필터링 후 재할당.
      state = state.where((m) => m.id != meal.id).toList();
      return false;
    } else {
      state = [...state, meal]; //기존 상태값에 meal 추가후 재할당.
      return true;
    }
  }
}

final favoritesMealsProvider = StateNotifierProvider<FavoriteMealsNotifier, List<Meal>>((ref) {
  return FavoriteMealsNotifier();
});
