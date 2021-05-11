
import java.util.ArrayList;
import java.util.Scanner;

public class Food {
    private String name;
    private ArrayList<Item> items;
    private String recipe;
    private double totalCalories;


    public Food() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Food name: ");
        this.name = scanner.nextLine();

        System.out.println("Do you want to enter new item (Y/N): ");
        String choice = scanner.nextLine();

        if(choice.equalsIgnoreCase("Y")){
            Item item = new Item();
            items.add(item);
        }

        System.out.print("Recipe: ");
        this.recipe = scanner.nextLine();
    }

    public Food(String name, ArrayList<Item> items, String recipe) {
        this.name = name;
        this.items = items;
        this.recipe = recipe;
        this.totalCalories = calculateCalories();
    }

    @Override
    public String toString() {
        String result = "\tFood name: " + this.name;

        int numberOfItem = 1;
        for (Item item : this.items) {
            result += "" + numberOfItem + item.toString();
        }
        result += "\nFood recipe: " + this.recipe;

        return result;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getRecipe() {
        return recipe;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    private double calculateCalories() {
        double totalCalories = 0;
        for (Item item : this.items) {
            totalCalories += item.getCalories() * item.getAmount();
        }
        return totalCalories;
    }
}
