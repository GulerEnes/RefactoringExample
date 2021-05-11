
import java.util.ArrayList;

public class Food {
    public String name;
    public ArrayList<Item> items;
    public String recipe;

    public Food(String name, ArrayList<Item> items, String recipe) {
        this.name = name;
        this.items = items;
        this.recipe = recipe;
    }

}
