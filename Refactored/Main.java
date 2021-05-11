
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void showMenu(){
        System.out.println("\n\n1. List all saved foods\n"+
                "2. Enter new food\n" +
                "3. Get total calories of a food\n"+
                "4. Show recipe of a food\n" +
                "5. Delete a food\n" +
                "6. Quit");
        System.out.print("\nChose what you want to do: ");
    }

    public static void listFoods(ArrayList<Food> foodList){
        int numberOfFood = 1;
        for(Food food: foodList){
            System.out.println("" + numberOfFood + food.toString());
        }
    }

    public static void deleteFood(ArrayList<Food> foodList){
        listFoods(foodList);
        System.out.print("Choose a food to delete: ");
        foodList.remove(new Scanner(System.in).nextInt() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************\n" +
                "* Welcome to Recipe Program *" +
                "\n*****************************");

        ArrayList<Food> foodList = new ArrayList<>();

        do{
            showMenu();

            switch (scanner.nextInt()){
                case 1:
                    listFoods(foodList);
                    break;
                case 2:
                    foodList.add(new Food());
                    break;
                case 3:
                    listFoods(foodList);
                    System.out.println("Total calories: " + foodList.get(scanner.nextInt() - 1).getTotalCalories());
                    break;
                case 4:
                    listFoods(foodList);
                    System.out.println(foodList.get(scanner.nextInt() - 1).toString());
                    break;
                case 5:
                    deleteFood(foodList);
                    break;
                case 6:
                    System.out.println("\n**********************\n" +
                            "* Bye! See You Later *" +
                            "\n**********************");
                    return;
                default:
                    System.out.println("You entered wrong number! ");
            }
        }while(true);
    }
}
