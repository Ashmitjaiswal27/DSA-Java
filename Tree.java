import java.util.ArrayList;

class Node{
    String data;
    ArrayList<Node> children;

    Node(String data){
        this.data = data;
        this.children = new ArrayList<Node>();
    }

    void addChildrean(Node node){
        this.children.add(node);
    }

    String print(int level){
        String ret;
        ret = "  ".repeat(level)+data+"\n";
        for(Node node: this.children){
            ret += node.print(level + 1);
        }
        return ret;
    }
}

public class Tree {
    public static void main(String[] args) {
        Node drinks = new Node("Drinks");
        Node hot = new Node("Hot");
        Node cold = new Node("Cold");
        Node tea = new Node("Tea");
        Node coffee = new Node("Coffee");
        Node wine = new Node("Wine");
        Node beer = new Node("Beer");
        drinks.addChildrean(hot);
        drinks.addChildrean(cold);
        hot.addChildrean(tea);
        hot.addChildrean(coffee);
        cold.addChildrean(wine);
        cold.addChildrean(beer);
        System.out.println(drinks.print(0));
    }
}
