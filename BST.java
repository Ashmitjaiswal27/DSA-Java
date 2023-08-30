import java.util.Queue;
import java.util.LinkedList;

class BNode{
    int data;
    int height;
    BNode left;
    BNode right;
}

class BinarySearchTree{
    BNode root;
    //Creation
    BinarySearchTree(){
        root = null;
        System.out.println("created");
    }
    //Insertion
    private BNode insertN(BNode curr,int data){
        if(curr == null){
            BNode node = new BNode();
            node.data= data;
            System.out.println("inserted");
            return node;
        }else if(data <= curr.data){
            curr.left = insertN(curr.left,data);
            return curr;
        }else{
            curr.right = insertN(curr.right,data);
            return curr;
        }
    }

    void insert(int data){
        root = insertN(root, data);
    }
    //PreOrder Traversal
    void preOrder(BNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //InOrder Traversal
    void inOrder(BNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    //Post Order Traversal
    void postOrder(BNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    //Level Order Traversal
    void levelOrder(){
        Queue<BNode> queue = new LinkedList<BNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BNode pre = queue.remove();
            System.out.print(pre.data+" ");
            if(pre.left != null){
                queue.add(pre.left);
            }
            if(pre.right != null){
                queue.add(pre.right);
            }
        }
    }
    //Search
    BNode search(BNode node, int data){
        if(node == null){
            System.out.println("doesn't exist");
            return null;
        }else if(node.data == data){
            System.out.println("found");
            return node;
        }else if(data < node.data){
            return search(node.left, data);
        }else{
            return search(node.right, data);
        }
    }
    //Delete
        //Minimum Node
        BNode minimumNode(BNode root){
            if(root.left == null){
                return root;
            }else{
                return minimumNode(root.left);
            }
        }

        BNode deleteNode(BNode root, int data){
            if(root == null){
                System.out.println("data not found");
                return null;
            }
            if(data < root.data){
                root.left = deleteNode(root.left, data);
            }else if(data>root.data){
                root.right = deleteNode(root.right, data);
            }else{
                if(root.left != null && root.right != null){
                    BNode temp = root;
                    BNode minright = minimumNode(temp.right);
                    root.data = minright.data;
                    root.right = deleteNode(root.right, minright.data);
                }else if(root.left != null){
                    root=root.left;
                }else if(root.right != null){
                    root = root.right;
                }else{
                    root = null;
                }
            }
            return root;
        }
}
public class BST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);
        bst.levelOrder();
        System.out.println();
        bst.deleteNode(bst.root,40);
        bst.levelOrder();
    }
}
