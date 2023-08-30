class QuickSort{

    static int partition(int[] arr, int start, int end){
        int pivot = end;
        int i = start -1;

        for(int j = start;j<=end;j++){
            if(arr[j] <= arr[pivot]){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    static void quickSort(int[] arr, int start, int  end){
        if(start<end){
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1, end);
        }
    }

    static void printArray(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

public class Quick_Sort {
    public static void main(String[] args) {
        int arr[] = {10,3,2,7,7,5,8,4,1,2,9,7,8,11};
        QuickSort.quickSort(arr,0,arr.length-1);
        QuickSort.printArray(arr);
    }
}
