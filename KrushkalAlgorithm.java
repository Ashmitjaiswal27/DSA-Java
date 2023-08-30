import java.util.*;


class WeightedNode implements Comparable<WeightedNode>{
    public String name;
    public ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited = false;
    public WeightedNode parent;
    public int distance;

    public DisjointSet set;

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

class DisjointSet {
    private ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public static void makeSet(ArrayList<WeightedNode> nodeList) {
        for (WeightedNode node : nodeList) {
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.set = set;
        }
    }

    public static DisjointSet findSet(WeightedNode node) {
        return node.set;
    }

    public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
        if (node1.set.equals(node2.set)) {
            return null;
        }else {
            DisjointSet set1 = node1.set;
            DisjointSet set2 = node2.set;

            if (set1.nodeList.size()>set2.nodeList.size()){
                ArrayList<WeightedNode> nodeSet2 = set2.nodeList;
                for (WeightedNode node: nodeSet2) {
                    node.set = set1;
                    set1.nodeList.add(node);
                }
                return set1;
            }else{
                ArrayList<WeightedNode> nodeSet1 = set1.nodeList;
                for (WeightedNode node : nodeSet1) {
                    node.set = set2;
                    set2.nodeList.add(node);
                }
                return set2;
            }
        }
    }

    public void printAllNodesofThisSet() {
        System.out.println("Printing all nodes of the set: ");
        for (WeightedNode node : nodeList ) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}

class UndirectedEdge{
    WeightedNode first ;
    WeightedNode second;
    int weight;

    UndirectedEdge(WeightedNode first, WeightedNode second, int weight){
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Edge ("+first+","+second+"), weight = "+weight;
    }
}

class krushkal{
    ArrayList<WeightedNode> nodeList = new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    krushkal(ArrayList<WeightedNode> nodeList){
        this.nodeList = nodeList;
    }

    void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight){
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
        WeightedNode first = edge.first;
        WeightedNode second = edge.second;
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
        edgeList.add(edge);
    }

    void kruskal(){
        DisjointSet.makeSet(nodeList);

        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>(){
            @Override
            public int compare(UndirectedEdge o1, UndirectedEdge o2){
                return o1.weight - o2.weight;
            }
        };

        Collections.sort(edgeList, comparator);
        int cost = 0;

        for(UndirectedEdge edge: edgeList){
            WeightedNode first = edge.first;
            WeightedNode second = edge.second;
            if(!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))){
                DisjointSet.union(first, second);
                cost += edge.weight;
                System.out.println("taken "+ edge);
            }
        }
        System.out.println("\nThe cost of MST: "+cost);
    }
}

public class KrushkalAlgorithm {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("A"));
        nodeList.add(new WeightedNode("B"));
        nodeList.add(new WeightedNode("C"));
        nodeList.add(new WeightedNode("D"));
        nodeList.add(new WeightedNode("E"));

        krushkal graph = new krushkal(nodeList);
        graph.addWeightedUndirectedEdge(0,1,5);
        graph.addWeightedUndirectedEdge(0,2,13);
        graph.addWeightedUndirectedEdge(0,4,15);
        graph.addWeightedUndirectedEdge(1,2,10);
        graph.addWeightedUndirectedEdge(1,3,8);
        graph.addWeightedUndirectedEdge(2,3,6);
        graph.addWeightedUndirectedEdge(2,4,20);

        graph.kruskal();

    }
}
