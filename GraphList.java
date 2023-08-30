import java.util.ArrayList;
import java.util.*;
import java.util.LinkedList;
import java.util.Stack;
class GraphNode{
    String name;
    int index;
    boolean isVisited = false;
    GraphNode parent;
    ArrayList<GraphNode> neighbours = new ArrayList<>();

    GraphNode(String name, int index){
        this.name = name;
        this.index = index;
    }
}

class Graph{
    ArrayList<GraphNode> nodelist = new ArrayList<>();

    Graph(ArrayList<GraphNode> nodelist){
        this.nodelist = nodelist;
    }
    
    void addUndirectedEdge(int i, int j){
        GraphNode first = nodelist.get(i);
        GraphNode second = nodelist.get(j);

        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    void bfsVisit(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode current = queue.remove();
            current.isVisited = true;
            System.out.print(current.name+ " ");
            for(GraphNode neighbour: current.neighbours){
                if(neighbour.isVisited == false){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void bfs(){
        for(GraphNode node: nodelist){
            if(!node.isVisited){
                bfsVisit(node);
            }
        }
    }
    
    void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            GraphNode current = stack.pop();
            current.isVisited = true;
            System.out.print(current.name+" ");
            for(GraphNode neighbour : current.neighbours){
                if(!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void dfs(){
        for(GraphNode node : nodelist){
            if(!node.isVisited){
                dfsVisit(node);
            }
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i=0;i<nodelist.size(); i++){
            s.append(nodelist.get(i).name + ": ");
            for(int j = 0; j<nodelist.get(i).neighbours.size(); j++){
                if(j == nodelist.get(i).neighbours.size() -1){
                    s.append(nodelist.get(i).neighbours.get(j).name);
                }else{
                    s.append((nodelist.get(i).neighbours.get(j).name)+"->");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    //Topological Sort
    void addDirectedEdge(int i, int j){
        GraphNode first = nodelist.get(i);
        GraphNode second = nodelist.get(j);
        first.neighbours.add(second);
    }

    void topologicalVisit(GraphNode node, Stack<GraphNode> stack){
        for(GraphNode neighbour : node.neighbours){
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
            System.out.print(stack.pop().name +" ");
        }
    }
    
    //path printing
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
            GraphNode current = queue.remove();
            current.isVisited = true;
            System.out.print("Printing Path from node "+current.name+": ");
            pathprint(current);
            System.out.println();
            for(GraphNode neighbour : current.neighbours){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited =true;
                    neighbour.parent = current;
                }
            }
        }
    }
}

public class GraphList {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodelist = new ArrayList<>();
        nodelist.add(new GraphNode("A", 0));
        nodelist.add(new GraphNode("B", 1));
        nodelist.add(new GraphNode("C", 2));
        nodelist.add(new GraphNode("D", 3));
        nodelist.add(new GraphNode("E", 4));
        nodelist.add(new GraphNode("F", 5));
        nodelist.add(new GraphNode("G", 6));

        Graph graph = new Graph(nodelist);
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

        graph.BFSforSSSPP(nodelist.get(0));
    }   
}
