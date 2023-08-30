class NOP{
    int nop(int[][] arr, int row, int col, int cost){
        if(cost<0)
        return 0;
        else if(row == 0 && col ==0){
            if(arr[0][0]-cost ==0)
            return 1;
            else
            return 0;
        }
        else if(row == 0){
            return nop(arr, 0, col-1, cost-arr[row][col]);
        }else if(col == 0){
            return nop(arr, row-1, 0, cost-arr[row][col]);
        }else{
            int op1 = nop(arr, row-1, col, cost-arr[row][col]);
            int op2 = nop(arr, row, col-1, cost-arr[row][col]);
            return op1+op2;
        }
    }
}
public class NumberOfPaths {
    public static void main(String[] args) {
        int[][] arr = {
            {4,7,1,6},
            {5,7,3,9},
            {3,2,1,2},
            {7,1,6,3}
        };
        int cost = 25;
        NOP n = new NOP();
        System.out.println(n.nop(arr, arr.length-1, arr[0].length-1, cost));
    }
}
