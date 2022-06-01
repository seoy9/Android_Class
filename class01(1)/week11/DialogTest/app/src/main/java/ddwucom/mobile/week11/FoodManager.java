package ddwucom.mobile.week11;

import java.util.ArrayList;

public class FoodManager {

    ArrayList<Food> foodList;

    public FoodManager() {
        foodList = new ArrayList<Food>();
        foodList.add(new Food("김치찌개", "한국"));
        foodList.add(new Food("된장찌개", "한국"));
        foodList.add(new Food("훠궈", "중국"));
        foodList.add(new Food("딤섬", "중국"));
        foodList.add(new Food("초밥", "일본"));
        foodList.add(new Food("오코노미야키", "일본"));
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    public void addFood(String food, String nation) {
        foodList.add(new Food(food, nation));
    }

    public void deleteFood(int index) {
        foodList.remove(index);
    }
}