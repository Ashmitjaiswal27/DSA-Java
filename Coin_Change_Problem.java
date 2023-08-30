import java.util.Arrays;

class CCP{
    static void ccp(int[] coins, int amount){
        Arrays.sort(coins);

        int index = coins.length -1;
        while(true){
            int coinValue = coins[index];
            index--;
            int maxamount = (amount/coinValue)*coinValue;
            if(maxamount>0){
                System.out.println(coinValue +"  "+ amount/coinValue);
                amount -= maxamount;
            }

            if(amount ==0){
                break;
            }
        }
    }
}

public class Coin_Change_Problem {
    public static void main(String[] args) {
        int[] coins = {1,2,5,10,20,50,100,1000};
        int amount = 2035;
        System.out.println(Arrays.toString(coins));
        System.out.println();
        CCP.ccp(coins, amount);
    }
}
