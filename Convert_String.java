class StringC{
    int findMinOP(String s1, String s2, int index1, int index2){
        if(index1 == s1.length())
            return s2.length()-index2;
        if(index2 == s2.length())
            return s1.length() - index1;
        if(s1.charAt(index1) == s2.charAt(index2))
            return findMinOP(s1, s2, index1+1, index2+1);
        else{
            int delete = 1+findMinOP(s1, s2, index1, index2+1);
            int insert = 1+findMinOP(s1, s2, index1+1, index2);
            int replace = 1+findMinOP(s1, s2, index1+1, index2+1);
            return Math.min(delete, Math.min(insert, replace));
        }
    }
}

public class Convert_String {
    public static void main(String[] args) {
        StringC st = new StringC();
        String s1 = "table";
        String s2 = "tbres";
        int min = st.findMinOP(s1, s2, 0, 0);
        System.out.println("min steps = "+min);
    }   
}