class Node{
    int data;
    Node next;
    Node prev;
}

class CircularDoublyLinkedList{
    Node head;
    Node tail;
    int size;

    //Creation
    Node createCDLL(int data){
        head = new Node();
        Node node = new Node();
        node.data = data;
        head = tail = node;
        node.next = node.prev = node;
        size=1;
        return head;
    }

    //Insertion
    void insertCDLL(int data, int location){
        Node node = new Node();
        node.data = data;

        if(head == null){
            createCDLL(data);
            return;
        }else if(location == 0){
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            head = node;
        }else if(location >= size){
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
            tail = node;
        }else{
            Node temp = head;
            int index = 0;
            while(index < location-1){
                temp = temp.next;
                index++;
            }
            node.prev = temp;
            node.next = temp.next;
            temp.next = node;
            node.next.prev = node;
        }
        size++;
    }

    //Traversal
    void traverseCDLL(){
        if(head == null){
            System.out.println("No LL");
        }else{
            Node temp = head;
            for(int i =0; i<size; i++){
                System.out.print(temp.data);
                if(i != size-1){
                    System.out.print("->");
                }
                temp = temp.next;
            }
        }
        System.out.println("\n");
    }

    //Reverse Traversal
    void reverseTraversalCDLL(){
        if(head != null){
            Node temp = tail;
            for(int i = 0; i<size; i++){
                System.out.print(temp.data);
                if(i != size-1){
                    System.out.print("<-");
                }
                temp = temp.prev;
            }
        }else{
            System.out.println("No LL");
        }
    }

    //Searching
    boolean searchCDLL(int data){
        if(head != null){
            Node temp = head;
            for(int i = 0; i<size; i++){
                if(temp.data == data){
                    System.out.println("\nfound at location: "+i);
                    return true;
                }
                temp= temp.next;
            }
        }
        System.out.println("\nNode not Found");
        return false;
    }

    //Deletion
    void deleteCDLL(int location){
        if(head == null){
            System.out.println("\nNo LL");
        }else if(location==0){
            if(size==1){
                head.prev = null;
                head.next = null;
                head = null;
                tail = null;
                size--;
                return;
            }else{
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
            }
        }else if(location >= size){
            if(size==1){
                head.prev = null;
                head.next = null;
                head = null;
                tail = null;
                size--;
                return;
            }else{
                tail =tail.prev;
                head.prev = tail;
                tail.next = head;
                size--;
            }
        }else{
            Node temp = head;
            for(int i =0; i<location-1; i++){
                temp =temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
        }
    }
}

public class CircularDLL {
    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
        cdll.createCDLL(1);
        cdll.insertCDLL(2, 0);
        cdll.insertCDLL(3, 2);
        cdll.insertCDLL(4, 5);
        cdll.traverseCDLL();
        cdll.reverseTraversalCDLL();
        cdll.searchCDLL(2);
        cdll.deleteCDLL(2);
        cdll.traverseCDLL();
    }
}