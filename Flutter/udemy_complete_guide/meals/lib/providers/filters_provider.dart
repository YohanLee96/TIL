import 'package:flutter_riverpod/flutter_riverpod.dart';


enum Filter { glutenFree, lactoseFree, vegetarian, vegan }


class FiltersNotifier extends StateNotifier<Map<Filter, bool>> {
  FiltersNotifier() : super({
    Filter.glutenFree: false,
    Filter.lactoseFree: false,
    Filter.vegetarian: false,
    Filter.vegan: false,
  });


  void setFilter(Filter filter, bool isActive) {
    state = {
      ...state,
      //인자로 받은 filter는 덮어씌워잠.
      filter: isActive,
    };
  }

}



final filtersProvider = StateNotifierProvider<FiltersNotifier, Map<Filter, bool>>((ref) => FiltersNotifier());


