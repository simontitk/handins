import java.util.ArrayList;

public class Forest {

    private ArrayList<Tree> trees;

    public Forest() {
        this.trees = new ArrayList<Tree>();
    }

    public void addTree(float growthRate) {
        this.trees.add(new Tree(growthRate));
    }

    public String toString() {
        String result = "Forest(";
        for (Tree t: this.trees) {
            result += t.toString();
        }
        return result + ")";
    }

    public void growOneYear() {
        for (Tree t: this.trees) {
            t.growOneYear();
        }
    }
    
}
