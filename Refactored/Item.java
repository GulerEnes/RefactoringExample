package ybu.datastruct;

import java.util.Scanner;

public class Item {
    private String name;
    private String type;
    private String unit;
    private double amount;
    private double calories;

    public Item(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Item name: ");
        this.name = scanner.nextLine();

        System.out.print("Item type: ");
        this.type = scanner.nextLine();

        System.out.print("Item unit: ");
        this.unit = scanner.nextLine();

        System.out.print("Item amount: ");
        this.amount = scanner.nextDouble();

        System.out.print("Item calories: ");
        this.calories = scanner.nextDouble();
    }

    public Item(String name, String type, String unit, double amount, double calories) {
        this.name = name;
        this.type = type;
        this.unit = unit;
        this.amount = amount;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "\n\tItem name: " + this.name +
                "\n\tItem type: " + this.type +
                "\n\tItem unit: " + this.unit +
                "\n\tItem amount: " + this.amount +
                "\n\tItem calories: " + this.calories;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getUnit() {
        return unit;
    }

    public double getAmount() {
        return amount;
    }

    public double getCalories() {
        return calories;
    }
}
