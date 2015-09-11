package CreatePattern;

// Define product
class BurgerMeal {
    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setBurger(String burger) {
        this.burger = burger;
    }

    private String drink;

    public String getDrink() {
        return drink;
    }

    public String getBurger() {
        return burger;
    }

    private String burger;
}

// Interface for product builder
interface MealBuilder {
    void buildBurger();
    void buildDrink();
    BurgerMeal buildMeal();
}

//Concrete product builder implementation
class BurgerMealBuilder implements MealBuilder {

    BurgerMeal burgerMeal;

    public BurgerMealBuilder() {
        burgerMeal = new BurgerMeal();
    }

    @Override
    public void buildBurger() {
        burgerMeal.setBurger("build burger");
    }

    @Override
    public void buildDrink() {
        burgerMeal.setDrink("build drink");
    }

    @Override
    public BurgerMeal buildMeal() {
        return burgerMeal;
    }
}

// Director who know which product build implementation know who to product product
class Chef {
    public BurgerMeal constructMeal(MealBuilder mealBuilder){
        mealBuilder.buildBurger();
        mealBuilder.buildDrink();

        return mealBuilder.buildMeal();
    }
}

public class Builder {
    public static void main(String[] args) {
        System.out.println("Builder!");

        Chef chef = new Chef();

        BurgerMeal burgerMeal = chef.constructMeal(new BurgerMealBuilder());

        System.out.println(burgerMeal.getBurger());
        System.out.println(burgerMeal.getDrink());
    }
}
