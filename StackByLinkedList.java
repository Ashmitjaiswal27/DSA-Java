class Node{
    int data;
    Node next;
}
class LinkedList{
    public Node head;
    public Node tail;
    int size;

    Node createsinglylinkedlist(int data){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.data = data;
        head = node;
        tail = node;
        size=1;
        return head;
    }

    //Insertion
    void insert(int data,int location){
        Node node = new Node();
        node.data = data;
        if(head == null){
            createsinglylinkedlist(data);
            return;
        }else if(location == 0){
            node.next = head;
            head = node;
        }else if(location >= size){
            node.next = null;
            tail.next = node;
            tail= node;
        }else{
            Node temp = head;
            int index=0;
            while(index<location-1){
                temp= temp.next;
                index++;
            }
            node.next = temp.next;
            temp.next = node;
        }
        size++;
    }

    //Deletion
    void delete(int location){
        if(head == null){
            System.out.println("No LL");
            return;
        }
        else if(location == 0){
            head = head.next;
            size--;
            if(size==0){
                tail=null;
            }
        }else if(location >= size){
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            if(temp == head){
                tail = head = null;
                size--;
                return;
            }
            temp.next = null;
            tail = temp;
            size--;

        }else{
            Node temp = head;
            for(int i =0;i< location -1;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
}

class Stack{
    LinkedList ll;
    //Creation
    Stack(){
        ll = new LinkedList();
    }
    //Push
    void push(int data){
        ll.insert(data, 0);
    }
    //isEmpty
    boolean isEmpty(){
        if(ll.head == null){
            return true;
        }else{
            return false;
        }
    }
    //Pop
    int pop(){
        int result = -1;
        if(isEmpty()){
            System.out.println("stack empty");
        }else{
            result = ll.head.data;
            ll.delete(0);
        }
        return result;
    }
    //Peek
    int peek(){
        if(isEmpty()){
            System.out.println("stack empty");
            return -1;
        }else{
            return ll.head.data;
        }
    }
}
public class StackByLinkedList {
    public static void main(String[] args) {
        Stack stk = new Stack();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        int res = stk.peek();
        System.out.println(res);
        int res1 = stk.peek();
        System.out.println(res1);
    }
}