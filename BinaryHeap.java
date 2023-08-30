class BHeap{
    int arr[];
    int sizeOfTree;

    //Creation 
    BHeap(int size){
        arr = new int[size+1];
        this.sizeOfTree =0;
        System.out.println("created");
    }
    //isEmpty
    boolean isEmpty(){
        if(sizeOfTree == 0){
            return true;
        }else{
            return false;
        }
    }
    //Peek
    Integer peek(){
        if(isEmpty()){
            System.out.println("empty");
            return null;
        }
        return arr[1];
    }
    //Size
    int sizeOfBP(){
        return sizeOfTree;
    }
    //Level Order Traversal
    void levelOrder(){
        for(int i =1; i<= sizeOfTree; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //Heapify for insert
    void heapifyBTT(int index, String heaptype){
        int parent = index/2;
        if(index <= 1){
            return;
        }
        if(heaptype == "Min"){
            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }else if(heaptype == "Max"){
            if(arr[index] > arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        heapifyBTT(parent, heaptype);
    }

    void insert(int value, String heaptype){
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBTT(sizeOfTree, heaptype);
    }
    //Heapify for extraction
    void heapifyTTB(int index, String heaptype){
        int left = index*2;
        int right = index*2+1;
        int swapchild =0;
        if(sizeOfTree < left){ //means there's no child of this node;
            return;
        }

        if(heaptype == "Max"){
            if(sizeOfTree == left){//only one child
                if(arr[index] < arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return ;
            }else{// two children
                if(arr[left] > arr[right]){
                    swapchild = left;
                }else{
                    swapchild = right;
                }
                if(arr[index] < arr[swapchild]){
                    int temp = arr[index];
                    arr[index] = arr[swapchild];
                    arr[swapchild] = temp;
                }
            }
        }else if(heaptype == "Min"){
            if(sizeOfTree == left){ //only one child
                if(arr[index] > arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return ;
            }else{
                if(arr[left] < arr[right]){
                    swapchild = left;
                }else{
                    swapchild = right;
                }
                if(arr[index] > arr[swapchild]){
                    int temp = arr[index];
                    arr[index] = arr[swapchild];
                    arr[swapchild] = temp;
                }
            }
        }
        heapifyTTB(swapchild, heaptype);
    }

    int extractHeap(String heaptype){
        if(isEmpty()){
            return -1;
        }
        else{
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTTB(1, heaptype);
            return extractedValue;
        }
    }
}

public class BinaryHeap {
    public static void main(String[] args) {
        BHeap bh = new BHeap(5);
        bh.insert(10, "Max");
        bh.insert(5, "Max");
        bh.insert(15, "Max");
        bh.insert(1, "Max");
        bh.levelOrder();
        bh.extractHeap("Max");
        bh.levelOrder();
    }
}
