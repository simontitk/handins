public class Tree {
    private int age;
    private double height;
    private double growthRate;


    public Tree(double growthRate) {
        this.age = 1;
        this.height = 0.12;
        this.growthRate = growthRate;
    }

    public String toString() {
        return "Tree(age = " + 
                this.age + 
                ", height = " +
                this.height +
                ")";
    }

    public void growOneYear() {
        this.age += 1;
        this.height = this.height * (1 + this.growthRate / 100);
        if (this.height > 14) {
            this.height = 14;
        }
    }


}