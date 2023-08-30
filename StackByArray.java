class Stack{
    int[] arr;
    int top;
    //Creation 
    Stack(int size){
        this.arr = new int[size];
        this.top = -1;
        System.out.println("Stack created!");
    }

    //isEmpty
    boolean isEmpty(){
        if(top == -1){
            return true;
        }else{
            return false;
        }
    }

    //isFull
    boolean isFull(){
        if(top == arr.length-1){
            //System.out.println("Stack is Full.");
            return true;
        }else{
            return false;
        }
    }
    
    //Push
    void push(int data){
        if(isFull()){
            System.out.println("No Push");
        }else{
            top++;
            arr[top] = data;
        }
    }

    //Pop
    int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            int element = arr[top];
            top--;
            return element;
        }
    }

    //Peek
    int peek(){
        if(isEmpty()){
            System.out.println("stack empty");
            return -1;
        }else{
            return arr[top];
        }
    }
}

public class StackByArray {
    public static void main(String[] args) {
        Stack stk = new Stack(4);
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        int result = stk.peek();
        System.out.println(result);
    }
}