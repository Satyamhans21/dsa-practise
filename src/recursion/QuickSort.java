package recursion;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int partition=func(arr,low,high);
            quickSort(arr,low,partition-1);
            quickSort(arr,partition+1,high);

        }
    }
    public static int func(int[] arr,int low,int high){
        int i=low;
        int j=high;
        int pivot=arr[low];
        while(i<j){
            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j){
//                int temp=arr[i];
//                arr[i]=arr[j];
//                arr[j]=temp;
                swap(arr,i,j);

            }

        }
//        int temp=arr[low];
//        arr[low]=arr[j];
//        arr[j]=temp;
        swap(arr,low,j);
        return j;
    }

    public static void swap(int[] arr, int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    public static void main(String[] args) {
        int[] arr={5,3,8,7,3,2,6,1};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
