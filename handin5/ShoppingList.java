import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingList {

    private Map<String, Integer> available;
    private Map<String, Integer> needed;


    public ShoppingList() {
        this.available = new TreeMap<>();
        this.needed = new TreeMap<>();
    }


    public void read() {
        Scanner scn = new Scanner(System.in);
        boolean saveIntoAvailable = scn.nextLine().contains("AVAILABLE"); //starts out as true
        while (scn.hasNext()) {
            String newline = scn.nextLine();
            if (newline.contains("RECIPE")) {
                saveIntoAvailable = false;
                continue;
            }
            String[] entry = newline.split(" ");
            String ingredient = entry[2];
            String unit = entry[1];
            int quantity = (unit.equals("g")) ? Integer.parseInt(entry[0]) : Integer.parseInt(entry[0]) * 1000;
            if (saveIntoAvailable) {
                this.available.put(ingredient, quantity);
            }
            else {
                if (this.needed.containsKey(ingredient)) {
                    this.needed.replace(ingredient, (this.needed.get(ingredient) + quantity));
                } 
                else {this.needed.put(ingredient, quantity);}
            } 
        }
        scn.close();
    }


    public void printShoppingList() {

        System.out.println("Shopping List:");

        for (var entry: this.needed.entrySet()) {

            String ingredient = entry.getKey();
            int quantity = entry.getValue();
            
            if (this.available.containsKey(ingredient)) {
                quantity -= this.available.get(ingredient);
            }
            if (quantity > 0) {
                System.out.println((quantity + " g " + ingredient));
            }
        }
    }
}