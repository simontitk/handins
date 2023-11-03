import java.util.ArrayList;
import java.util.List;

public class Order {

    protected List<Food> ordered;

    public Order() {
        this.ordered = new ArrayList<>();
    }

    public int total() {
        int total = 0;
        for (Food food: this.ordered) {
            total += food.getPrice();
        }
        return total;
    }

    public void display() {
        this.ordered.forEach(Food::display);
        System.out.println(this.total() + " kr TOTAL");
    }

    public boolean payWith(CreditCard card) {
        int amount = this.total();
        boolean withdrawOk = card.withdraw(amount);
        if (withdrawOk){
            return withdrawOk;
        }
        else {
            System.out.println("ERROR: Payment failed");
            return withdrawOk;
        }
    }

    public void addFood(Food food) {
        this.ordered.add(food);
        
    }
    
}
