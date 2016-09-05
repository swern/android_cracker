package com.example.user.cracker;

/**
 * Created by user on 24/08/2016.
 */
public class DataProvider {

    private String food_type;
    private String calories;
    private String meal;

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public DataProvider(String food_type, String calories, String meal){
        this.food_type = food_type;
        this.calories = calories;
        this.meal = meal;
    }

}
