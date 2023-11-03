import java.util.ArrayList;
import java.util.List;

public class Pizza extends Food{

    protected List<String> toppings;

    public Pizza() {
        super("Pizza", 45);
        this.toppings = new ArrayList<>();
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
        this.price += 10;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void display() {
        int size = this.toppings.size();
        String tops = " ";

        for (int i = 0; i < size; i++) {
            tops += this.toppings.get(i) + (i==size-1 ? " " : ", ");
        }

        System.out.println(this.price + " kr " + this.name + " {" + tops + "}");

    }

}
