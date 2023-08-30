class MergeSort{

    static void mergeSort(int[]arr, int left, int right){
        if(right>left){
            int mid = (left+right)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[]a, int left, int mid, int right){
        int[] leftTempArray = new int[mid -left+2];
        int[] rightTempArray = new int[right-mid+1];

        for(int i =0; i<= mid-left; i++){
            leftTempArray[i] = a[left + i];
        }
        for(int i = 0 ; i<right-mid; i++){
            rightTempArray[i] = a[mid+1+i];
        }

        leftTempArray[mid-left+1] = Integer.MAX_VALUE;
        rightTempArray[right-mid] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for(int k = left; k<=right; k++){
            if(leftTempArray[i]<rightTempArray[j]){
                a[k] = leftTempArray[i];
                i++;
            }else{
                a[k] = rightTempArray[j];
                j++;
            }
        }
    }

    static void printArray(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

public class Merge_Sort {
   public static void main(String[] args) {
       int[] arr = {10,3,2,5,8,4,3,1,2,9,7,8};
       MergeSort.mergeSort(arr, 0, arr.length-1);
       MergeSort.printArray(arr);
   } 
}
