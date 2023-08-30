import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class GraphNode{
    String name;
    int index;
    GraphNode parent;
    boolean isVisited = false;

    GraphNode(String name, int index){
        this.name = name;
        this.index = index;
    }
}

class Graph{
    ArrayList<GraphNode> nodelist = new ArrayList<>();
    int[][] adjacencyMatrix;

    Graph(ArrayList<GraphNode> nodeList){
        this.nodelist = nodeList;
        this.adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    void addUndirectedEdge(int i, int j){
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for(int i= 0; i<nodelist.size(); i++){
            s.append(nodelist.get(i).name +" ");
        }
        s.append("\n");
        for(int i =0; i<nodelist.size(); i++){
            s.append(nodelist.get(i).name +": ");
            for(int j : adjacencyMatrix[i]){
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    //get neighbours
    ArrayList<GraphNode> getNeighbours(GraphNode node){
        ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();
        int index = node.index;
        for(int i = 0; i<adjacencyMatrix.length; i++){
            if(adjacencyMatrix[index][i] == 1){
                neighbours.add(nodelist.get(i));
            }
        }
        return neighbours;
    }

    //BSF
    void bfsVisit(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode current = queue.remove();
            current.isVisited = true;
            System.out.print(current.name+ " ");
            ArrayList<GraphNode> neighbours = getNeighbours(current);
            for(GraphNode neighbour: neighbours){
                if(neighbour.isVisited == false){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void bfs(){
        for(GraphNode node : nodelist){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }

    void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<GraphNode>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNode current = stack.pop();
            current.isVisited = true;
            System.out.print(current.name+ " ");
            ArrayList<GraphNode> neighbours = getNeighbours(current);
            for(GraphNode neighbour: neighbours){
                if(neighbour.isVisited == false){
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void dfs(){
        for(GraphNode node: nodelist){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }

    //Topological Sort
    void addDirectedEdge(int i, int j){
        adjacencyMatrix[i][j] =1;
    }

    void topologicalVisit(GraphNode node, Stack<GraphNode> stack){
        ArrayList<GraphNode> neighbours = getNeighbours(node);
        for(GraphNode neighbour : neighbours){
            if(!neighbour.isVisited){
                topologicalVisit(neighbour, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    void topologicalSort(){
        Stack<GraphNode> stack = new Stack<GraphNode>();
        for(GraphNode node : nodelist){
            if(!node.isVisited){
                topologicalVisit(node, stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().name + " ");
        }
    }
    //printing path
    static void pathprint(GraphNode node){
        if(node.parent != null){
            pathprint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    void BFSforSSSPP(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode current =  queue.remove();
            current.isVisited = true;
            System.out.print("Printing Path for node "+current.name+": ");
            pathprint(current);
            System.out.println();
            ArrayList<GraphNode> neighbours = getNeighbours(current);
            for(GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = current;
                }
            }
        }
    }
}

public class GraphMatrix {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));

        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(1, 3);
        graph.addUndirectedEdge(1, 6);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(3, 5);
        graph.addUndirectedEdge(4, 5);
        graph.addUndirectedEdge(5, 6);
        System.out.println(graph.toString());

        graph.BFSforSSSPP(nodeList.get(0));
    }
}