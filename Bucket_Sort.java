import java.util.ArrayList;
import java.util.Collections;

class BucketSort{
    int arr[];

    BucketSort(int arr[]){
        this.arr = arr;
    }

    void printBucket(ArrayList<Integer>[] buckets){
        for(int i=0; i<buckets.length; i++){
            System.out.println("\nBucket "+i+" :");
        
            for(int j=0; j<buckets[i].size(); j++){
                System.out.print(buckets[i].get(j)+" ");
            }
        }
    }

    void printArray(){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    void bucketSort(){
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int max = Integer.MIN_VALUE;

        for(int value : arr){
            if(value>max)
            max = value;
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];

        for(int i = 0; i<buckets.length; i++){
            buckets[i] = new ArrayList<Integer>();
        }

        for(int value : arr){
            int bucketNumber = (int) Math.ceil(((float)value*numberOfBuckets)/(float)max);
            buckets[bucketNumber-1].add(value);
        }

        System.out.println("\n\n Printing buckets before Sorting");
        printBucket(buckets);

        for(ArrayList<Integer> bucket : buckets){
            Collections.sort(bucket);
        }

        System.out.println("\n\n Printing buckets after Sorting");
        printBucket(buckets);

        int index = 0;
        for(ArrayList<Integer> bucket: buckets){
            for(int value: bucket){
                arr[index] = value;
                index++;
            }
        }
    }
}


public class Bucket_Sort {
    public static void main(String[] args) {
        int arr[] = {9,7,5,4,2,1,3,6,8};
        BucketSort bs = new BucketSort(arr);
        bs.printArray();
        bs.bucketSort();
        System.out.println();
        bs.printArray();
    }   
}