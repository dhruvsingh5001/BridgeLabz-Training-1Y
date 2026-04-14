import java.util.*;

interface MealPlan {
    String getDetails();
}

class VegetarianMeal implements MealPlan {
    public String getDetails() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getDetails() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getDetails() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getDetails() {
        return "High Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void showMeal() {
        System.out.println(meal.getDetails());
    }
}

class MealUtil {
    public static <T extends MealPlan> Meal<T> generateMeal(T meal) {
        return new Meal<>(meal);
    }
}

public class Main {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = MealUtil.generateMeal(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealUtil.generateMeal(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealUtil.generateMeal(new KetoMeal());
        Meal<HighProteinMeal> hpMeal = MealUtil.generateMeal(new HighProteinMeal());

        vegMeal.showMeal();
        veganMeal.showMeal();
        ketoMeal.showMeal();
        hpMeal.showMeal();
    }
}