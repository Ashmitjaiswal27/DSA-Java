class LCS{
    int findCSL(String s1, String s2, int i1, int i2){
        if(i1 == s1.length() || i2==s2.length())
            return 0;
        if(s1.charAt(i1)==s2.charAt(i2)){
            return 1+findCSL(s1, s2, i1+1, i2+1);
        }else{
            int op1 = findCSL(s1, s2, i1+1, i2);
            int op2 = findCSL(s1, s2, i1, i2+1);
            return Math.max(op1, op2);
        }
    }
}

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        LCS s = new LCS();
        System.out.println(s.findCSL("elephant", "erepat", 0, 0));
    }
}