import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

class WeightedNode implements Comparable<WeightedNode>{
    public String name;
    public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited = false;
    public WeightedNode parent;
    public int distance;

    public WeightedNode(String name) {
        this.name = name;
        distance = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(WeightedNode o) {
        return this.distance - o.distance;
    }
}

class Prims{
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    Prims(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int d){
        WeightedNode first = nodeList.get(firstIndex);
        WeightedNode second = nodeList.get(secondIndex);
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, d);
        second.weightMap.put(first, d);
    }

    //Prims Algo
    void prims(WeightedNode node){
        for(int i =0; i<nodeList.size(); i++){
            nodeList.get(i).distance = Integer.MAX_VALUE;
        }

        node.distance = 0;

        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while(!queue.isEmpty()){
            WeightedNode current = queue.remove();
            for(WeightedNode neighbour : current.neighbors){
                if(queue.contains(neighbour)){
                    if(neighbour.distance > current.weightMap.get(neighbour)){
                        neighbour.distance =current.weightMap.get(neighbour);
                        neighbour.parent = current;
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

        int cost = 0;

        for(WeightedNode nodeToCheck : nodeList){
            System.out.println("Node "+ nodeToCheck+",key "+ nodeToCheck.distance+ " Parent: "+ nodeToCheck.parent);
            cost = cost+nodeToCheck.distance;
        }
        System.out.println("\nTotal cost of MST: "+ cost);
    }
}

public class PrimsAlgorithm {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A"));
        nodeList.add(new WeightedNode("B"));
        nodeList.add(new WeightedNode("C"));
        nodeList.add(new WeightedNode("D"));
        nodeList.add(new WeightedNode("E"));

        Prims graph = new Prims(nodeList);
        graph.addWeightedUndirectedEdge(0,1,5);
        graph.addWeightedUndirectedEdge(0,2,13);
        graph.addWeightedUndirectedEdge(0,4,15);
        graph.addWeightedUndirectedEdge(1,2,10);
        graph.addWeightedUndirectedEdge(1,3,8);
        graph.addWeightedUndirectedEdge(2,3,6);
        graph.addWeightedUndirectedEdge(2,4,20);

        graph.prims(nodeList.get(4));

    }
}
