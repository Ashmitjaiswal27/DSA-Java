import java.util.ArrayList;
import java.util.HashMap;

class WeightedNode implements Comparable<WeightedNode>{
    String name;
    ArrayList<WeightedNode> neighbours = new ArrayList<>();
    HashMap<WeightedNode, Integer> weightmap = new HashMap<>();
    boolean isVisited = false;
    WeightedNode parent;
    int distance;
    int index;

    WeightedNode(String name, int index){
        this.name = name;
        this.index = index;
        distance = Integer.MAX_VALUE;
        parent = null;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
    @Override
    public int compareTo(WeightedNode o){
        return this.distance - o.distance;
    }
}

class WeightedGraph{
    ArrayList<WeightedNode> nodelist = new ArrayList<>();

    WeightedGraph(ArrayList<WeightedNode> nodelist){
        this.nodelist = nodelist;
    }

    void addWeightedEdge(int i, int j, int d){
        WeightedNode first = nodelist.get(i);
        WeightedNode second = nodelist.get(j);
        first.neighbours.add(second);
        first.weightmap.put(second, d);
    }

    static void pathprint(WeightedNode node){
        if(node.parent != null){
            pathprint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    void bellmanFord(WeightedNode source){
        source.distance = 0;
        for(int i=0; i<nodelist.size(); i++){
            for(WeightedNode current : nodelist){
                for(WeightedNode neighbour: current.neighbours){
                    if(neighbour.distance > current.distance + current.weightmap.get(neighbour)){
                        neighbour.distance = current.distance + current.weightmap.get(neighbour);
                        neighbour.parent = current;
                    }
                }
            }
        }

        System.out.println("Checking for negative cycle..");
        for(WeightedNode current : nodelist){
            for(WeightedNode neighbour: current.neighbours){
                if(neighbour.distance > current.distance + current.weightmap.get(neighbour)){
                    System.out.println("Negative cycle found: \n");
                    System.out.println("Vertex name: "+ neighbour.name);
                    System.out.println("Old cost: "+ neighbour.distance);
                    int newDistance = current.distance + current.weightmap.get(neighbour);
                    System.out.println("new cost: "+ newDistance);
                    return;
                }
            }
        }
        System.out.println("Negative cycle not found\n");

        for(WeightedNode nodetoCheck : nodelist){
            System.out.print("Node "+ nodetoCheck + ", distance: "+ nodetoCheck.distance+", Path: ");
            pathprint(nodetoCheck);
            System.out.println();
        }
    }

}

public class BellmanFordAlgorithm {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodelist = new ArrayList<>();
        nodelist.add(new WeightedNode("A",0));
        nodelist.add(new WeightedNode("B",1));
        nodelist.add(new WeightedNode("C",2));
        nodelist.add(new WeightedNode("D",3));
        nodelist.add(new WeightedNode("E",4));
        nodelist.add(new WeightedNode("F",5));
        nodelist.add(new WeightedNode("G",6));

        WeightedGraph graph = new WeightedGraph(nodelist);
        graph.addWeightedEdge(0,1,2);
        graph.addWeightedEdge(0,2,5);
        graph.addWeightedEdge(1,2,6);
        graph.addWeightedEdge(1,3,1);
        graph.addWeightedEdge(1,4,3);
        graph.addWeightedEdge(2,5,8);
        graph.addWeightedEdge(3,4,4);
        graph.addWeightedEdge(4,6,9);
        graph.addWeightedEdge(5,6,7);

        graph.bellmanFord(nodelist.get(0));
    }
}
