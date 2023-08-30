import java.util.ArrayList;

class LinearProbing{
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size){
        hashTable = new String[size];
        usedCellNumber =0;
    }
    
    int modASCII(String word, int M){
        char ch[];
        ch = word.toCharArray();
        int i, sum =0;
        for(sum=0,i=0;i<word.length();i++){
            sum += ch[i];
        }
        return sum % M;
    }

    double getLoadFactor(){
        double lf = usedCellNumber*1.0/hashTable.length;
        return lf;
    }

    //rehash
    void rehash(String word){
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<String>();
        for(String s : hashTable){
            if(s!= null){
                data.add(s);
            }
        }
        data.add(word);
        hashTable = new String[hashTable.length*2];

        for(String s : data){
            insertHashTable(s);
        }
    }
    //insert
    void insertHashTable(String word){
        double loadFactor = getLoadFactor();

        if(loadFactor >= 0.75){
            rehash(word);
        }else{
            int index = modASCII(word, hashTable.length);

            for(int i = index; i<hashTable.length; i++){
                int newIndex = i%hashTable.length;
                if(hashTable[newIndex]== null){
                    hashTable[newIndex] = word;
                    System.out.println("successfully inserted at location: "+newIndex);
                    break;
                }else{
                    System.out.println("index occupied. trying next empty cell;");
                }
            }
        }
        usedCellNumber++;
    }

    void displayHashTable(){
        if(hashTable == null){
            System.out.println("hash table doesn't exists");
            return;
        }else{
            for(int i =0;i<hashTable.length;i++){
                System.out.println("index: "+i+ " key: "+ hashTable[i]);
            }
        }
    }
    //search
    boolean searchHashTable(String word){
        int index = modASCII(word, hashTable.length);

        for(int i = index;i<hashTable.length;i++){
            int newIndex = i%hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex] == word){
                System.out.println("found at location: "+newIndex);
                return true;
            }
        }
        System.out.println("not found");
        return false;
    }
    //Delete
    void delete(String word){
        int index = modASCII(word, hashTable.length);
        for(int i = index;i<hashTable.length;i++){
            int newIndex = i%hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex] == word){
                hashTable[newIndex] = null;
                System.out.println("deleted");
                return;
            }
        }
        System.out.println("Not Found");
    }
}

public class Linear_Probing_Hashing {
    public static void main(String[] args) {
        LinearProbing lp = new LinearProbing(13);
        lp.insertHashTable("The");
        lp.insertHashTable("quick");
        lp.insertHashTable("brown");
        lp.insertHashTable("fox");
        lp.insertHashTable("over");
        lp.delete("fox");
        lp.displayHashTable();
    }
}
