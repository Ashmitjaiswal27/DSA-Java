class QueueArray{
    int[] arr;
    int rear;
    int front;
    //Creation
    QueueArray(int size){
        this.arr = new int[size];
        this.rear = -1;
        this.front = -1;
        System.out.println("created queue");
    }
    //isFull
    boolean isFull(){
        if(rear == arr.length-1){
            return true;
        }else{
            return false;
        }
    }
    //isEmpty
    boolean isEmpty(){
        if(front == -1 || front == rear){
            return true;
        }else{
            return false;
        }
    }
    //Enqueue
    void Enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full");
        }else if(isEmpty()){
            front=0;
            rear++;
            arr[rear] = data;
        }else{
            rear++;
            arr[rear] = data;
        }
    }
    //Dequeue
    int Dequeue(){
        if(isEmpty()){
            System.out.println("Empty");
            return -1;
        }else{
            int result = arr[front];
            front++;
            if(front>rear){
                front = rear =-1;
            }
            return result;
        }
    }
    //Peek
    int peek(){
        if(!isEmpty()){
            return arr[front];
        }
        else{
            System.out.println("empty");
            return -1;
        }
    }
}

public class QueueByArray {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(3);
        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        System.out.println(queue.arr[queue.rear]);
    }
}