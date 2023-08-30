//Find no. of ways to express N as sum of 1, 3 and 4.
class numfac{
    int waysToGet(int N){
        if(N==0 || N==1||N==2){
            return 1;
        }
        if(N==3){
            return 2;//{1,1,1},{3}
        }
        return waysToGet(N-1)+ waysToGet(N-3)+waysToGet(N-4);
    }
}

public class Number_Factor {
    public static void main(String[] args) {
        numfac nf = new numfac();
        System.out.println(nf.waysToGet(4));
        System.out.println(nf.waysToGet(5));
        System.out.println(nf.waysToGet(6));
    }
}