import java.util.ArrayList;

class DoubleHashing{
    String[] hashTable;
    int usedCellNumber;

    DoubleHashing(int size){
        hashTable = new String[size];
        usedCellNumber = 0;
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

    int addAllDigits(int sum){
        int value = 0;
        while(sum>0){
            value += sum%10;
            sum /= 10;
        }
        return value;
    }

    int secondHashFunction(String x,int M){
        char ch[];
        ch = x.toCharArray();
        int i,sum =0;
        for(sum =0, i =0; i<x.length();i++){
            sum += ch[i];      
        }

        while(sum>hashTable.length){
            sum = addAllDigits(sum);
        }

        return sum%M;
    }

    double getLoadFactor(){
        double lf = usedCellNumber*1.0/hashTable.length;
        return lf;
    }

    void insertHashTable(String word){
        double load = getLoadFactor();
        if(load >= 0.75){
            rehash(word);
        }else{
            int index = modASCII(word, hashTable.length);
            int y = secondHashFunction(word, hashTable.length);

            for(int i = 0; i<hashTable.length; i++){
                int newIndex = (index + i*y)%hashTable.length;
                if(hashTable[newIndex]== null){
                    hashTable[newIndex] = word;
                    System.out.println("inserted at location: "+ newIndex);
                    break;
                }
                else{
                    System.out.println("trying next index");
                }
            }
        }
        usedCellNumber++;
    }
}

public class Double_hashing {
    public static void main(String[] args) {
        DoubleHashing dh = new DoubleHashing(13);
        dh.insertHashTable("The");
        dh.insertHashTable("quick");
        dh.insertHashTable("brown");
        dh.insertHashTable("fox");
        dh.insertHashTable("over");
        dh.insertHashTable("lazy");
        dh.displayHashTable();
    }
}
