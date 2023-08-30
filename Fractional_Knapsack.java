import java.util.*;
class item{
    int index;
    int value;
    int weight;
    double ratio;

    item(int index, int value, int weight){
        this.index = index;
        this.value = value;
        this.weight = weight;
        ratio = value*1.0/weight;
    }

    @Override
    public String toString() {
        return "Item Index: "+index+", value: "+ value+", weight: "+weight+", ratio: "+ratio;        
    }
}

class fracKnap{
    static void knapsack(ArrayList<item> items, int capacity){
        Comparator<item> comp = new Comparator<item>() {
            @Override
            public int compare(item one, item two){
                if(two.ratio>one.ratio)
                    return 1;
                else
                    return -1;
            }
        };

        Collections.sort(items, comp);
        int usedCapacity = 0;
        double totalValue =0;

        for(item item : items){
            if(usedCapacity + item.weight<= capacity){
                usedCapacity += item.weight;
                System.out.println("taken :- "+ item);
                totalValue += item.value;
            }else{
                int usedWeight = capacity-usedCapacity;
                double value = item.ratio*usedWeight;
                System.out.println("taken:- item index: "+item.index+", obtained value: "+value+", used weight: "+usedWeight+", ratio: "+item.ratio);
                totalValue += value;
                usedCapacity += usedWeight;
            }

            if(usedCapacity == capacity)
                break;
        }

        System.out.println("total value obtained: "+ totalValue);
    }
}

public class Fractional_Knapsack {
    public static void main(String[] args) {
        ArrayList<item> items = new ArrayList<>();
        int[] value = {100,120,60};
        int[] weight = {20,30,10};

        int capacity = 50;
        for(int i=0; i<value.length; i++){
            items.add(new item(i+1, value[i], weight[i]));
        }

        fracKnap.knapsack(items, capacity);
    }
}
