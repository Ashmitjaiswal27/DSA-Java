import java.util.Queue;
import java.util.LinkedList;

class bNode{
    String data;
    bNode left;
    bNode right;
    int height;
}

class BinaryTreeLinkedList{
    bNode root;
    //Creation
    BinaryTreeLinkedList(){
        this.root = null;
    }
    //Pre Order Traversal
    void preOrder(bNode node){
        if(node== null){
            return;
        }
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //In Order Traversal
    void inOrder(bNode node){
        if(node== null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data +" ");
        inOrder(node.right);
    }
    //Post Order Traversal
    void postOrder(bNode node){
        if(node== null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    //Level Order traversal
    void levelOrder(){
        Queue<bNode> queue = new LinkedList<bNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            bNode node = queue.remove();
            System.out.print(node.data + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
    //Searching
    void search(String data){
        Queue<bNode> queue = new LinkedList<bNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            bNode node = queue.remove();
            if(node.data == data){
                System.out.println("Success found");
                return;
            }else{
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        System.out.println("Not found");
    }
    //Insertion
    void insert(String data){
        bNode node = new bNode();
        node.data = data;
        if(root == null){
            root = node;
            System.out.println("Inserted new node at root");
            return;
        }
        Queue<bNode> queue = new LinkedList<bNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            bNode pre = queue.remove();
            if(pre.left == null){
                pre.left = node;
                System.out.println("sucessfully inserted");
                break;
            }else if(pre.right == null){
                pre.right= node;
                System.out.println("sucessfully inserted");
                break;
            }else{
                queue.add(pre.left);
                queue.add(pre.right);
            }
        }
    }
    //Deletion{
        //Get Deepest Node
        bNode getDeepestNode(){
            Queue<bNode> queue = new LinkedList<bNode>();
            queue.add(root);
            bNode present = null;
            while(!queue.isEmpty()){
                present = queue.remove();
                if(present.left != null){
                    queue.add(present.left);
                }
                if(present.right != null){
                    queue.add(present.right);
                }
            }
            return present;
        }
        //Delete Deepest Node
        void deleteDeepestNode(){
            Queue<bNode> queue = new LinkedList<bNode>();
            queue.add(root);
            bNode previous,present = null;
            while(!queue.isEmpty()){
                previous = present;
                present = queue.remove();
                if(present.left==null){
                    previous.right = null;
                    return;
                }
                else if(present.right==null){
                    present.left = null;
                    return;
                }
                queue.add(present.left);
                queue.add(present.right);
            }
        }
        //delete given node
        void delete(String data){
            Queue<bNode> queue = new LinkedList<bNode>();
            queue.add(root);
            while(!queue.isEmpty()){
                bNode presentnode = queue.remove();
                if(presentnode.data == data){
                    presentnode.data = getDeepestNode().data;
                    deleteDeepestNode();
                    System.out.println("node deleted");
                    return;
                }else{
                    if(presentnode.left != null){
                        queue.add(presentnode.left);
                    }
                    if(presentnode.right != null){
                        queue.add(presentnode.right);
                    }
                }
            }
            System.out.println("node doesn't exist in tree");
        }
    //}
}

public class BinaryTreeByLL {
    public static void main(String[] args) {
        BinaryTreeLinkedList btll = new BinaryTreeLinkedList();
        btll.insert("N1");
        btll.insert("N2");
        btll.insert("N3");
        btll.insert("N4");
        btll.insert("N5");
        btll.insert("N6");
        

        btll.preOrder(btll.root);
        System.out.println();
        btll.inOrder(btll.root);
        System.out.println();
        btll.postOrder(btll.root);
        System.out.println();
        btll.search("N7");
        btll.levelOrder();
        System.out.println();
        btll.delete("N3");
        btll.levelOrder();
        btll.delete("N2");
        btll.levelOrder();
    }
}
