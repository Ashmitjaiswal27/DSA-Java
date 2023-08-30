class ZKnap{
    int knap(int[] profits,int[] weights ,int capacity, int Index){
        if(capacity<=0||Index<0||Index>=profits.length){
            return 0;
        } 
        int Option1=0,Option2=0;
        if(weights[Index]<= capacity){
             Option1= profits[Index]+ knap(profits, weights, capacity-weights[Index], Index+1);
             Option2= knap(profits, weights, capacity, Index+1);
        }
        return Math.max(Option1, Option2);
    }
}

public class ZeroOneKnapSack {
    public static void main(String[] args) {
        ZKnap kp = new ZKnap();
        int[] profits = {31,26,17,72};
        int[] weights = {3,1,2,5};
        int max = kp.knap(profits, weights, 7, 0);
        System.out.println(max);
    }
}