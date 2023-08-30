class QueueArray{
    int[] arr;
    int front;
    int rear;
    int size;

    //Creation
    QueueArray(int size){
        this.arr = new int[size];
        this.front =-1;
        this.rear = -1;
        this.size = size;
        System.out.println("created");
    }
    //isEmpty
    boolean isEmpty(){
        if(rear==-1){
            return true;
        }else{
            return false;
        }
    }
    //isFull
    boolean isFull(){
        if(rear + 1== front){
            return true;
        }else if(front == 0 && rear+1 == size){
            return true;
        }else{
            return false;
        }
    }
    //enQueue
    void enQueue(int data){
        if(isFull()){
            System.out.println("Full");
        }else if(isEmpty()){
            front = 0;
            rear++;
            arr[rear] = data;
        }else{
            if(rear+1 == size){
                rear = 0;
            }else{
                rear++;
            }
            arr[rear] = data;
        }
    }
    //Dequeue
    int Dequeue(){
        if(isEmpty()){
            System.out.println("empty");
            return -1;
        }else{
            int res = arr[front];
            arr[front] = 0; //0 denotes cell is empty
            if(front == rear){
                front = rear = -1;
            }else if(front + 1 == size){
                front = 0;
            }else{
                front++;
            }
            return res;
        }
    }

    //Peek
    int peek(){
        if(isEmpty()){
            System.out.println("empty");
            return -1;
        }else{
            return arr[front];
        }
    }
}

public class CircularQueueByArray {
    public static void main(String[] args) {
        QueueArray que = new QueueArray(3);
        que.enQueue(10);
        que.enQueue(20);
        que.enQueue(30);
        int res = que.peek();
        System.out.println(res);
        int res1 = que.peek();
        System.out.println(res1);
    }
}
