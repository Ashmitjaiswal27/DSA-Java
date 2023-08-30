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
    void heapifyBTT(int index){
        int parent = index/2;
        if(index <= 1){//root of tree;
            return;
        }
        if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
        }
        
        heapifyBTT(parent);
    }

    void insert(int value){
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBTT(sizeOfTree);
    }
    //Heapify for extraction
    void heapifyTTB(int index){
        int left = index*2;
        int right = index*2+1;
        int swapchild =0;
        if(sizeOfTree < left){ //means there's no child of this node;
            return;
        }
        else if(sizeOfTree == left){ //only one child
            if(arr[index] > arr[left]){
                int temp = arr[index];
                arr[index] = arr[left];
                arr[left] = temp;
            }
            return ;
        }else{//both children
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
        heapifyTTB(swapchild);
    }

    int extractHeap(){
        if(sizeOfTree == 0){
            return -1;
        }
        else{
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTTB(1);
            return extractedValue;
        }
    }
}

class HeapSort{
    int[] arr = null;

    HeapSort(int[] arr){
        this.arr = arr;
    }

    void sort(){
        BHeap bh = new BHeap(arr.length);

        for(int i=0; i<arr.length; i++){
            bh.insert(arr[i]);
        }

        for(int i=0; i<arr.length; i++){
            arr[i] = bh.extractHeap();
        }
    }

    void printArray(){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

public class Heap_Sort {
    public static void main(String[] args) {
        int arr[] = {2,7,3,1,4,8,9};
        HeapSort hs = new HeapSort(arr);
        hs.sort();
        hs.printArray();
    }
}
