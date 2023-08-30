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

    void floydWarshall(){
        int size = nodelist.size();
        int[][] V = new int[size][size];

        for(int i=0; i<size; i++){
            WeightedNode first = nodelist.get(i);
            for(int j= 0; j<size; j++){
                WeightedNode second = nodelist.get(j);
                if(i==j){
                    V[i][j] = 0;
                }else if(first.weightmap.containsKey(second)){
                    V[i][j] = first.weightmap.get(second);
                }else{
                    V[i][j] = Integer.MAX_VALUE/10;
                }
            }
        }

        for(int k = 0; k< size; k++){
            for(int i = 0; i<size; i++){
                for(int j =0; j<size; j++){
                    if(V[i][j] > V[i][k] + V[k][j]){
                        V[i][j] = V[i][k] + V[k][j];
                    }
                }
            }
        }

        for(int i=0; i<size; i++){
            System.out.print("printing distance list for node "+nodelist.get(i)+": ");
            for(int j =0; j<size; j++){
                System.out.print(V[i][j]+ " ");
            }
            System.out.println();
        }
    }
}

public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodelist = new ArrayList<>();
        nodelist.add(new WeightedNode("A",0));
        nodelist.add(new WeightedNode("B",1));
        nodelist.add(new WeightedNode("C",2));
        nodelist.add(new WeightedNode("D",3));

        WeightedGraph graph = new WeightedGraph(nodelist);
        graph.addWeightedEdge(0,3,1);
        graph.addWeightedEdge(0,1,8);
        graph.addWeightedEdge(1,2,1);
        graph.addWeightedEdge(2,0,4);
        graph.addWeightedEdge(3,1,2);
        graph.addWeightedEdge(3,2,9);

        graph.floydWarshall();
    }
}
