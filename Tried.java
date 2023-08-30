import java.util.HashMap;
import java.util.Map;

class trieNode{
    Map<Character, trieNode> children;
    boolean endOfString;

    trieNode(){
        children = new HashMap<>();
        endOfString = false;
    }
}

class trie{
    private trieNode root;
    //Creation
    trie(){
        root = new trieNode();
        System.out.println("created");
    }
    //Insertion
    void insert(String word){
        trieNode current = root;
        for(int i=0; i<word.length();i++){
            char ch = word.charAt(i);
            trieNode node = current.children.get(ch);

            if(node == null){
                node = new trieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;

        System.out.println("inserted");
    }
    //Search
    boolean search(String word){
        trieNode current = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            trieNode node = current.children.get(ch);

            if(node == null){
                System.out.println("doesn't exist");
                return false;
            }
            current = node;
        }

        if(current.endOfString == true){
            System.out.println("exists");
            return true;
        }else{
            System.out.println("doesn't exist but prefix");
        }
        return current.endOfString;
    }
    //Delete
    private boolean delete(trieNode parentNode, String word, int index){
        char ch = word.charAt(index);
        trieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;

        if(currentNode.children.size()>1){
            delete(currentNode, word, index+1);
            return false;
        }

        if(index == word.length()-1){
            if(currentNode.children.size()>=1){
                currentNode.endOfString = false;
                return false;
            }else{
                parentNode.children.remove(ch);
                return true;
            }
        }

        if(currentNode.endOfString == true){
            delete(currentNode, word, index+1);
            return false;
        }

        canThisNodeBeDeleted = delete(currentNode, word, index+1);
        if(canThisNodeBeDeleted == true){
            parentNode.children.remove(ch);
            return true;
        }else{
            return false;
        }
    }

    void delete(String word){
        if(search(word)== true){
            delete(root, word, 0);
        }
    }
}

public class Tried {
    public static void main(String[] args) {
        trie t = new trie();
        t.insert("API");
        t.insert("APIS");

        t.delete("APIS");
        t.search("APIS");
    }
}
