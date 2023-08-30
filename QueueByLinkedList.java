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

class QueueLinkedList{
    LinkedList list;
    //Creation
    QueueLinkedList(){
        list = new LinkedList();
        System.out.println("created");
    }
    //isEmpty
    boolean isEmpty(){
        if(list.head == null){
            return true;
        }
        return false;
    }
    //enqueue
    void enqueue(int data){
        list.insert(data, list.size);
    }
    //dequeue
    int dequeue(){
        int data=-1;
        if(isEmpty()){
            System.out.println("Empty");
        }else{
            data = list.head.data;
            list.delete(0);
        }
        return data;
    }
    //Peek
    int peek(){
        if(isEmpty()){
            System.out.println("empty");
            return -1;
        }else{
            return list.head.data;
        }
    }
}

public class QueueByLinkedList {
    public static void main(String[] args){
        QueueLinkedList qll = new QueueLinkedList();
        qll.enqueue(10);
        qll.enqueue(20);
        qll.enqueue(30);
        int res = qll.peek();
        System.out.println(res);
        int res1 = qll.peek();
        System.out.println(res1);
    }
}