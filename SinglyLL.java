class Node{
    int data;
    Node next;
}

class SinglyLinkedList{
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

    //Insertion in SLL
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

    // Traverseral
    void traverse(){
        if(head == null){
            System.out.println("No LL");
        }else{
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.print("null\n");
        }
    }

    //Searching

    boolean search(int data){
        if(head != null ){
            Node temp = head;
            int i=0;
            while(temp != null){
                if(temp.data == data){
                    System.out.println("found at location: "+ i);
                    return true;
                }
                temp=temp.next;
                i++;
            }
        }
        System.out.println("Node not Found!");
        return false;
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

public class SinglyLL{
    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();
        sLL.createsinglylinkedlist(5);
        System.out.println(sLL.head.data);
        
        sLL.insert(6, 1);
        sLL.insert(7, 3);
        sLL.insert(8, 4);
        sLL.insert(9, 5);
        // System.out.println(sLL.head.next.data);
        // System.out.println(sLL.size);
        sLL.traverse();
       // sLL.search(5);
        sLL.delete(10);
        sLL.traverse();
    }
}