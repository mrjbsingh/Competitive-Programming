package leetcode.leetcode_contest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {

    Map<String, FoodRating> foodMap;
    Map<String, PriorityQueue<FoodRating>> cuisineTopFoods;
    class FoodRating {
        String food;
        Integer rating;
        String cuisine;

        public FoodRating(String food, Integer rating, String cuisine) {
            this.food = food;
            this.rating = rating;
            this.cuisine = cuisine;
        }
    }
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;

        foodMap = new HashMap<>();
        cuisineTopFoods = new HashMap<>();

        for(int i=0; i<n; i++){
            FoodRating foodRating = new FoodRating(foods[i], ratings[i], cuisines[i]);
            foodMap.put(foods[i], foodRating);
            updateCuisineTopFood(foodRating);
        }
    }

    public void changeRating(String food, int newRating) {
        FoodRating foodRating = foodMap.get(food);
        cuisineTopFoods.get(foodRating.cuisine).remove(foodRating);
        foodRating.rating = newRating;
        cuisineTopFoods.get(foodRating.cuisine).offer(foodRating);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<FoodRating> pq = cuisineTopFoods.get(cuisine);
        FoodRating foodRating = pq.peek();
        return foodRating.food;
    }

    public void updateCuisineTopFood(FoodRating foodRating){
        String cuisine = foodRating.cuisine;
        if(cuisineTopFoods.containsKey(cuisine)) {
            cuisineTopFoods.get(cuisine).offer(foodRating);
        }
        else {
                PriorityQueue<FoodRating> pq = new PriorityQueue<>(new sortFood());
                pq.offer(foodRating);
                cuisineTopFoods.put(cuisine, pq);
        }
    }
    class sortFood implements Comparator<FoodRating>{

        @Override
        public int compare(FoodRating f1, FoodRating f2) {
            if( f1.rating.equals(f2.rating)){
                return f1.food.compareTo(f2.food);
            }
            return f2.rating.compareTo(f1.rating);
        }
    }

    public static void main(String[] args) {
        String foods[] = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String cuisines[] = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int ratings[] = {9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings( foods, cuisines, ratings);
        foodRatings.highestRated("korean"); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        foodRatings.highestRated("japanese"); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        foodRatings.highestRated("japanese");
    }
}
/*
["FoodRatings","changeRating","highestRated","changeRating","changeRating","highestRated"]
[[["czopaaeyl", 12
"lxoozsbh", 2
"kbaxapl"], 8
["dmnuqeatj","dmnuqeatj","dmnuqeatj"],[11,2,15]],
["czopaaeyl",12],["dmnuqeatj"],["kbaxapl",8],["lxoozsbh",5],["dmnuqeatj"]]

["FoodRatings","highestRated","highestRated","changeRating","highestRated","changeRating","highestRated"]
[[["kimchi", 9   k
"miso",12       j
"sushi",16       j
"moussaka", 15  g
"ramen", 16     j
"bulgogi" 7     k
],["korean","japanese","japanese","greek","japanese","korean"],[9,12,8,15,14,7]],
["korean"],["japanese"],["sushi",16],["japanese"],["ramen",16],["japanese"]]
 */