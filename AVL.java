import java.util.Queue;
import java.util.LinkedList;

class BNode{
    int data;
    int height;
    BNode left;
    BNode right;

    BNode(){
        this.height = 0;
    }
}

class AVLtree{
    BNode root;

	//Creation
	AVLtree() {
		root = null;
	}
    //PreOrder Traversal
    public void preOrder(BNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //Inorder Traversal
    public void inOrder(BNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    //PostOrder Traversal
    public void postOrder(BNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    //Level Order Traversal
    void levelOrder() {
        Queue<BNode> queue = new LinkedList<BNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BNode presentNode = queue.remove();
            System.out.print(presentNode.data + " ");
            if (presentNode.left != null) {
            queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
            queue.add(presentNode.right);
            }
        }
    }

    //Search
    BNode search(BNode node, int data) {
        if (node == null ) {
            System.out.println("data: "+ data+ " not found in AVL");
            return null;
        } else if (node.data == data) {
            System.out.println("data: "+ data+ " found in AVL");
            return node;
        } else if (data < node.data) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }

    //getHeight
    public int getHeight(BNode node) {
        if (node == null) {
        return 0;
        }
        return node.height;
    }

    //rotateRight
    private BNode rotateRight(BNode disbalancedNode) {
        BNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //rotateLeft
    private BNode rotateLeft(BNode disbalancedNode) {
        BNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //getBalance
    public int getBalance(BNode node) {
        if (node == null) {
        return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    //Insert
    private BNode insertNode(BNode node, int data) {
        if (node == null) {
            BNode newNode = new BNode();
            newNode.data = data;
            newNode.height = 1;
            return newNode;
        } else if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else {
            node.right = insertNode(node.right, data);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && data < node.left.data) {
            return rotateRight(node);
        }

        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && data > node.right.data) {
            return rotateLeft(node);
        }

        if (balance < - 1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void insert(int data) {
        root = insertNode(root, data);
    }
    //Minimum Node
    static BNode minimumNode(BNode root){
        if(root.left == null){
            return root;
        }
        return minimumNode(root.left);
    }
    //Delete
    BNode deleteNode(BNode node, int data){
        if(node == null){
            System.out.println("Not found");
            return node;
        }
        if(data < node.data){
            node.left = deleteNode(node.left, data);
        }else if(data > node.data){
            node.right = deleteNode(node.right, data);
        }else{
            if(node.left != null && node.right != null){
                BNode temp = node;
                BNode minNode = minimumNode(temp.right);
                node.data = minNode.data;
                node.right = deleteNode(node.right, minNode.data);
            }else if(node.left != null){
                node = node.left;
            }else if(node.right != null){
                node = node.right;
            }else{
                node = null;
            }
        }
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left)>=0 ) {
            return rotateRight(node);
        }

        if (balance > 1 && getBalance(node.left)<0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.right)<=0) {
            return rotateLeft(node);
        }

        if (balance < - 1 && getBalance(node.right)>0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    void delete(int data){
        root = deleteNode(root, data);
    }
}




public class AVL {
    public static void main(String[] args) {
        AVLtree avl = new AVLtree();   
        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(20);
        avl.levelOrder();
        avl.delete(5);
        System.out.println();
        avl.levelOrder();
    }
}
