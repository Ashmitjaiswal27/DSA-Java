public class Main{

    static int retInt(){
        int a =100;
        try{
           // a = a/0;
            System.out.println("hh");
            return a;
        }catch(Exception e){
            System.out.println("catch");
            return a-1;
        }
        finally{
            System.out.println("finally");
        }
    }
    public static void main(String[] args) {
        System.out.println(retInt());
    }
}
