public class Main {

    public static void main(String[] args) {

        Forest f = new Forest();

        f.addTree(50);
        f.addTree(50);
        f.addTree(50);

        System.out.println(f.toString().equals("Forest(Tree(age = 1, height = 0.12)Tree(age = 1, height = 0.12)Tree(age = 1, height = 0.12))"));
        f.growOneYear();
        System.out.println(f.toString().equals("Forest(Tree(age = 1, height = 0.12)Tree(age = 1, height = 0.12)Tree(age = 1, height = 0.12))"));


        
    }
    
}
