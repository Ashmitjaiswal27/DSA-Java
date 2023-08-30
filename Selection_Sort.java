class SelectionSort{
    static void selectionSort(int[] a){
        for(int j = 0; j<a.length; j++){
            int minIndex = j;
            for(int i = j+1; i<a.length; i++){
                if(a[i]<a[minIndex]){
                    minIndex = i;
                }
            }
            if(minIndex != j){
                int temp = a[j];
                a[j] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }

    static void printArray(int[] a){
        for(int i = 0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}

public class Selection_Sort {
    public static void main(String[] args) {
        int array[] = {10,3,2,5,8,4,1,9};
        SelectionSort.selectionSort(array);
        SelectionSort.printArray(array);
    }
}