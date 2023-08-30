class BinaryTree{
    String[] arr;
    int lastusedIndex;
    //Creation
    BinaryTree(int size){
        arr = new String[size+1];
        this.lastusedIndex =0;
        System.out.println("created");
    }
    //isFull
    boolean isFull(){
        if(arr.length-1 == lastusedIndex)
            return true;
        return false;
    }
    //Insertion
    void insert(String data){
        if(!isFull()){
            arr[lastusedIndex+1] = data;
            lastusedIndex++;
            System.out.println("inserted");
        }else{
            System.out.println("BT is full");
        }
    }
    //Pre Order Traversal
    void preOrder(int index){
        if(index>lastusedIndex)
            return;
        System.out.print(arr[index]+" ");
        preOrder(index*2);
        preOrder(index*2+1);
    }
    //InOrder Traversal
    void inOrder(int index){
        if(index>lastusedIndex)
            return;
        inOrder(index*2);
        System.out.print(arr[index]+" ");
        inOrder(index*2+1);
    }
    //Post Order Traversal
    void postOrder(int index){
        if(index>lastusedIndex)
            return;
        postOrder(index*2);
        postOrder(index*2+1);
        System.out.print(arr[index]+" ");
    }
    //Level Order Traversal
    void levelOrder(){
        for(int i=1;i<=lastusedIndex;i++){
            System.out.print(arr[i]+" ");
        }
    }
    //Search
    int search(String data){
        for(int i=1;i<=lastusedIndex;i++){
            if(arr[i] == data){
                System.out.println("found at index: "+i);
                return i;
            }
        }
        System.out.println("node not found");
        return -1;
    }
    //Delete
    void delete(String data){
        int location = search(data);
        if(location==-1){
            return;
        }else{
            arr[location]= arr[lastusedIndex];
            lastusedIndex--;
            System.out.println("Node deleted");
        }
    }
}

public class BinaryTreeByArray {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(9);
        bt.insert("N1");
        bt.insert("N2");
        bt.insert("N3");
        bt.insert("N4");
        bt.insert("N5");
        bt.insert("N6");
        bt.insert("N7");
        bt.insert("N8");
        bt.insert("N9");
        bt.preOrder(1);
        // bt.levelOrder();
        // System.out.println();
        // bt.delete("N10");
        // System.out.println();
        // bt.levelOrder();
    }
}
