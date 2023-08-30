

class HouseRobber{
    private int moneyMax(int[] HousesNetWorth, int currentIndex){
        if(currentIndex>=HousesNetWorth.length){
            return 0;
        }
        int stealCurrent = HousesNetWorth[currentIndex]+ moneyMax(HousesNetWorth, currentIndex+2);
        int skipCurrent = moneyMax(HousesNetWorth, currentIndex+1);
        return Math.max(stealCurrent, skipCurrent);
    }

    int Maxmoney(int[] HousesNetWorth){
        return moneyMax(HousesNetWorth, 0);
    }
}

public class House_Robber {
    public static void main(String[] args) {
        int[] HousesNetWorth = {6,7,1,30,8,2,4};
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.Maxmoney(HousesNetWorth));
    }
}
