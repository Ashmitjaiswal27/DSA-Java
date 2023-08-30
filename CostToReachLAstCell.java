class RLC{
    int rlc(int[][] cost, int row, int col){
        if(row==-1||col==-1)
        return Integer.MAX_VALUE;
        if(row==0&& col==0)
        return cost[row][col];
        
        int op1 = rlc(cost, row-1, col);
        int op2 = rlc(cost, row, col-1);
        return cost[row][col]+Math.min(op1, op2);
    }
}
public class CostToReachLAstCell {
    public static void main(String[] args) {
        int[][] arr = {
            {4,7,8,6,4},
            {6,7,3,9,2},
            {3,8,1,2,4},
            {7,1,7,3,7},
            {2,9,8,9,3}
        };
        RLC r =new RLC();
        System.out.println(r.rlc(arr, arr.length-1, arr[0].length-1));
    }
}