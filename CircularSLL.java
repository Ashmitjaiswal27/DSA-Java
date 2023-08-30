class Node{
    int data;
    Node next;
}

class CircularSinglyLinkedList {
    Node head;
    Node tail;
    int size;

    // Creation
    Node createCSLL(int data){
        head = new Node();
        Node node = new Node();
        node.data = data;
        node.next = node;
        head = node;
        tail = node;
        size=1;
        return head;
    }   
    
    //Insertion
    void insertCSLL(int data, int location){
        Node node = new Node();
        node.data = data;

        if(head == null){
            createCSLL(data);
            return;
        }else if(location == 0){
            node.next = head;
            head = node;
            tail.next = head;
        }else if(location >= size){
            tail.next = node;
            tail = node;
            tail.next = head;
        }else{
            Node temp = head;
            int index = 0;
            while(index < location-1){
                temp = temp.next;
                index++;
            }
            node.next = temp.next;
            temp.next = node;
        }
        size++;
    }

    // Traversal
    void traverseCSLL(){
        if(head == null){
            System.out.println("No LL");
        }else{
            Node temp = head;
            for(int i = 0; i<size; i++){
                System.out.print(temp.data);
                if(i != size-1){
                    System.out.print("->");
                }
                temp = temp.next;
            }
        }
        System.out.println("\n");
    }

    // Search
    boolean searchCSLL(int data){
        if(head != null){
            Node temp = head;
            for(int i =0; i<size;i++){
                if(temp.data == data){
                    System.out.println("\nFound at location: "+i);
                    return true;
                }
                temp = temp.next;
            }
        }
        System.out.println("\nNode not found");
        return false;
    }

    //Deletion
    void deleteCSLL(int location){
        if(head == null){
            System.out.println("No LL");
            return;
        }else if(location == 0){
            head = head.next;
            tail.next = head;  
            size--;
            if(size == 0){
                tail = null;
                head.next = null;
                head = null;
            }
        }else if(location>= size){
            Node temp = head;
            for(int i =0; i<location-1;i++){
                temp = temp.next;
            }

            if(temp == head){
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            temp.next = head;
            tail = temp;
            size--;
        }else{
            Node temp = head;
            for(int i =0; i< location-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
}

public class CircularSLL {
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCSLL(5);
        csll.insertCSLL(4, 0);
        csll.insertCSLL(6, 1);
        csll.insertCSLL(7, 8);
        System.out.println(csll.head.data);
        csll.traverseCSLL();
        //csll.searchCSLL(10);
        csll.deleteCSLL(1);
        csll.traverseCSLL();
    }   
}
