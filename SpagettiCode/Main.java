import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scannerS = new Scanner(System.in);
        Scanner scannerN = new Scanner(System.in);
        System.out.println("*****************************\n" +
                "* Welcome to Recipe Program *" +
                "\n*****************************");

        ArrayList<Food> arr = new ArrayList<>();

        do {
            System.out.println("\n\n1. List all saved foods\n" +
                    "2. Enter new food\n" +
                    "3. Get total calories of a food\n" +
                    "4. Show recipe of a food\n" +
                    "5. Delete a food\n" +
                    "6. Quit");
            System.out.print("\nChose what you want to do: ");

            int x = scannerN.nextInt(); // Chose

            if (x == 1) {
                for (int i = 0; i < arr.size(); i++) {
                    System.out.println("Food Name: " + arr.get(i).name);
                    for (int j = 0; j < arr.get(i).items.size(); j++) {
                        System.out.println("" + (j + 1) + ".");
                        System.out.println("\tItem name: " + arr.get(i).items.get(j).name);
                        System.out.println("\tItem type: " + arr.get(i).items.get(j).type);
                        System.out.println("\tItem unit: " + arr.get(i).items.get(j).unit);
                        System.out.println("\tItem amount: " + arr.get(i).items.get(j).amount);
                        System.out.println("\tItem calories: " + arr.get(i).items.get(j).calories);
                    }

                    System.out.println("Recipe: " + arr.get(i).recipe);
                }
                if (arr.size() == 0)
                    System.out.println("Food database is empty. You may try to add new foods.");
            }
            else if (x == 2) {
                ArrayList<Item> l = new ArrayList<>();

                System.out.print("Food Name: ");
                String foodName = scannerS.nextLine();

                do {
                    String itemName, itemType, itemUnit;
                    double itemAmount, itemCalories;

                    System.out.print("Item name: ");
                    itemName = scannerS.nextLine();

                    System.out.print("Item type: ");
                    itemType = scannerS.nextLine();

                    System.out.print("Item unit: ");
                    itemUnit = scannerS.nextLine();

                    System.out.print("Item amount: ");
                    itemAmount = scannerN.nextDouble();

                    System.out.print("Item calories for (1 " + itemUnit + "): ");
                    itemCalories = scannerN.nextDouble();

                    Item i = new Item(itemName, itemType, itemUnit, itemAmount, itemCalories);
                    l.add(i);


                    System.out.println("Do you want to enter new item (Y/N): ");
                    String y = scannerS.nextLine();


                    if (!(y.equalsIgnoreCase("N") || y.equalsIgnoreCase("Y"))) {
                        System.out.println("Wrong choice!");
                        while (!(y.equalsIgnoreCase("N") || y.equalsIgnoreCase("Y"))) {
                            System.out.println("Do you want to enter new item (Y/N): ");
                            y = scannerS.nextLine();
                        }
                    } else if (y.equalsIgnoreCase("N"))
                        break;
                    else if (y.equalsIgnoreCase("Y"))
                        continue;

                } while (true);


                System.out.print("Recipe: ");
                String recipe = scannerS.nextLine();

                Food f = new Food(foodName, l, recipe);
                arr.add(f);
            }
            else if (x == 3) {
                System.out.println("Food list:");
                for (int i = 0; i < arr.size(); i++)
                    System.out.println("\t" + (i + 1) + ". " + arr.get(i).name);
                System.out.print("Choose a food to calculate calories: ");

                int c = scannerN.nextInt() - 1;
                double totalCal = 0;
                for (int j = 0; j < arr.get(c).items.size(); j++)
                    totalCal += arr.get(c).items.get(j).calories * arr.get(c).items.get(j).amount;

                System.out.println("Total calories of " + arr.get(c).name + " is " + totalCal);

            }
            else if (x == 4) {
                System.out.println("Food list:");
                for (int i = 0; i < arr.size(); i++)
                    System.out.println("\t" + (i + 1) + ". " + arr.get(i).name);
                System.out.print("Choose a food to see recipe: ");
                int c = scannerN.nextInt() - 1;

                System.out.println("Food Name: " + arr.get(c).name);
                for (int j = 0; j < arr.get(c).items.size(); j++) {
                    System.out.println("" + (j + 1) + ".");
                    System.out.println("\tItem name: " + arr.get(c).items.get(j).name);
                    System.out.println("\tItem type: " + arr.get(c).items.get(j).type);
                    System.out.println("\tItem unit: " + arr.get(c).items.get(j).unit);
                    System.out.println("\tItem amount: " + arr.get(c).items.get(j).amount);
                    System.out.println("\tItem calories: " + arr.get(c).items.get(j).calories);
                }

                System.out.println("Recipe: " + arr.get(c).recipe);
            }
            else if (x == 5) {
                System.out.println("Food list:");
                for (int i = 0; i < arr.size(); i++)
                    System.out.println("\t" + (i + 1) + ". " + arr.get(i).name);
                System.out.print("Choose a food to delete: ");
                int c = scannerN.nextInt() - 1;

                try {
                    arr.remove(c);
                    System.out.println("Food successfully deleted!");
                } catch (Exception e) {
                    System.out.println("Wrong choise! There is no such amount food in list.");
                }

            }
            else if (x == 6)
                break;
            else
                System.out.println("You entered wrong number! ");

        } while (true);

        System.out.println("\n**********************\n" +
                "* Bye! See You Later *" +
                "\n**********************");

    }
}
