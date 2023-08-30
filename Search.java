class Searching{

    static int linearSearch(int[] arr, int value){
        for(int i =0; i<arr.length; i++){
            if(arr[i] == value){
                System.out.println("element found at index: "+i);
                return i;
            }
        }
        System.out.println("element not found");
        return -1;
    }

    static int BinarySearch(int[] arr, int value){
        int start = 0;
        int end = arr.length-1;
        int mid = (start+end)/2;

        while(arr[mid] != value && start<=end){
            if(value < arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
            mid = (start+end)/2;
        }
        if(arr[mid] == value){
            System.out.println("element Found at Index: "+ mid);
            return mid;
        }
        System.out.println("element not found");
        return-1;
    }
}


public class Search {
    public static void main(String[] args) {
        int[] arr = {8,9,12,15,17,19,20,21,28};
        Searching.linearSearch(arr, 15);
        Searching.BinarySearch(arr, 25);
    }

}