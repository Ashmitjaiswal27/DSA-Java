import java.util.LinkedList;

class DirectChaining{
    LinkedList<String>[] hashtable;
    int maxChainsize = 5;

    DirectChaining(int size){
        hashtable = new LinkedList[size];
    }
    //Hash function
    int modASCII(String word, int M){
        char ch[];
        ch = word.toCharArray();
        int i, sum =0;
        for(sum=0,i=0;i<word.length();i++){
            sum += ch[i];
        }
        return sum % M;
    }
    //insert
    void insertHashTable(String word){
        int newIndex = modASCII(word, hashtable.length);

        if(hashtable[newIndex]== null){
            hashtable[newIndex] = new LinkedList<String>();
            hashtable[newIndex].add(word);
        }
        else{
            hashtable[newIndex].add(word);
        }
    }

    void displayHashTable(){
        if(hashtable == null){
            System.out.println("hash table doesn't exists");
            return;
        }else{
            for(int i =0;i<hashtable.length;i++){
                System.out.println("index: "+i+ "key: "+ hashtable[i]);
            }
        }
    }
    //Search
    boolean searchHashTable(String word){
        int newIndex = modASCII(word, hashtable.length);

        if(hashtable[newIndex] != null && hashtable[newIndex].contains(word)){
            System.out.println("Found");
            return true;
        }
        else{
            System.out.println("not found");
            return false;
        }
    }
    //Delete
    void deleteHashTable(String word){
        int newIndex = modASCII(word, hashtable.length);

        boolean result = searchHashTable(word);
        if(result == true){
            hashtable[newIndex].remove(word);
            System.out.println("deleted");
        }
    }
}

public class Chaining_Hashing {
    public static void main(String[] args) {
        DirectChaining dc = new DirectChaining(13);
        dc.insertHashTable("The");
        dc.insertHashTable("quick");
        dc.insertHashTable("brown");
        dc.insertHashTable("fox");
        dc.insertHashTable("over");
        dc.deleteHashTable("fox");
        dc.displayHashTable();
    }
}
