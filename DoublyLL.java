class Node{
    int data;
    Node prev;
    Node next;
}

class DoublyLinkedList{
    Node head;
    Node tail;
    int size;

    //Creation
    Node createDLL(int data){
        head = new Node();
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.prev = null;
        head = node;
        tail = node;
        size=1;
        return head;
    }

    //Insertion
    void insertDLL(int data,int location){
        Node node = new Node();
        node.data = data;

        if(head == null){
            createDLL(data);
            return;
        }else if(location == 0){
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }else if(location>=size){
            node.next = null;
            node.prev = tail;
            tail.next = node;
            tail = node;
        }else{
            Node temp = head;
            int index = 0;
            while(index < location-1){
                temp = temp.next;
                index++;
            }
            node.next = temp.next;
            node.prev = temp;
            node.next.prev = node;
            temp.next = node;
        }
        size++;
    }

    //Traversal
    void traverseDLL(){
        if(head != null){
            Node temp = head;
            int index=0;
            while(index <size){
                System.out.print(temp.data);
                if(index != size-1){
                    System.out.print("->");
                }
                temp = temp.next;
                index++;
            }
        }else{
            System.out.println("No LL");
        }
        System.out.println("\n");
    }

    //Reverse Traversal
    void reverseTraverseDLL(){
        if(head != null){
            Node temp = tail;
            int index = 0;
            while(index < size){
                System.out.print(temp.data);
                if(index != size-1){
                    System.out.print("<-");
                }
                temp = temp.prev;
                index++;
            }
        }else{
            System.out.println("No LL");
        }
        System.out.println("\n");
    }

    //Searching
    boolean Search(int data){
        if( head != null){
            Node temp = head;
            for(int i =0; i<size; i++){
                if(temp.data == data){
                    System.out.println("Found at location : "+i);
                    return true;
                }
                temp = temp.next;
            }
        }
        System.out.println("node not found");
        return false;
    }

    //Deletion
    void deleteDLL(int location){
        if(head == null){
            System.out.println("No LL");
            return;
        }else if(location == 0){
            if(size == 1){
                head = null;
                tail = null;
                size--;
                return;
            }else{
                head = head.next;
                head.prev = null;
                size--;
            }
        }else if(location >= size){
            if(size == 1){
                head = tail = null;
                size--;
                return;
            }else{
                Node temp = tail.prev;
                temp.next = null;
                tail = temp;
                size--;
            }
        }else{
            Node temp = head;
            for(int i =0; i<location-1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
        }
    }
}

public class DoublyLL {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createDLL(1);
        System.out.println(dll.head.data);
        dll.insertDLL(2, 0);
        dll.insertDLL(3, 1);
        dll.insertDLL(4, 7);
        dll.traverseDLL();
        dll.reverseTraverseDLL();
        dll.Search(5);
        dll.deleteDLL(1);
        dll.traverseDLL();
    }
}
