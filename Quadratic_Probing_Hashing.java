import java.util.ArrayList;

class QuadraticProbing{
    String[] hashTable;
    int usedCellNumber;

    QuadraticProbing(int size){
        hashTable = new String[size];
        usedCellNumber = 0;
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
    //Insert
    void insertHashTable(String word){
        double load = getLoadFactor();
        if(load>=0.75){
            rehash(word);
        }
        else{
            int index = modASCII(word, hashTable.length);
            int counter = 0;
            for(int i = index;i<index+hashTable.length;i++){
                int newIndex = (index + (counter*counter))%hashTable.length;
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = word;
                    System.out.println("inserted "+ word+" at index: "+ newIndex);
                    break;
                }else{
                    System.out.println("trying for other index");
                }
                counter++;
            }
        }
        usedCellNumber++;
    }
}

public class Quadratic_Probing_Hashing {
    public static void main(String[] args) {
        QuadraticProbing qp = new QuadraticProbing(13);
        qp.insertHashTable("The");
        qp.insertHashTable("quick");
        qp.insertHashTable("brown");
        qp.insertHashTable("fox");
        qp.insertHashTable("over");
        qp.insertHashTable("lazy");
        qp.displayHashTable();
    }
}
