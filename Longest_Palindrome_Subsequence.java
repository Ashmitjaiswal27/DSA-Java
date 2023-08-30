class LPS{
    int lps(String s, int i1, int i2){
        if(i1>i2)
        return 0;
        if(i1 == i2)
        return 1;
        if(s.charAt(i1)==s.charAt(i2)){
            return 2+lps(s, i1+1, i2-1);
        }else{
            int op1 = lps(s, i1+1, i2);
            int op2 = lps(s, i1, i2-1);
            return Math.max(op1, op2);
        }
    }
}

public class Longest_Palindrome_Subsequence {
    public static void main(String[] args) {
        LPS lp = new LPS();
        String s = "ELRMENMET";
        System.out.println(lp.lps(s, 0, s.length()-1));
    }
}
