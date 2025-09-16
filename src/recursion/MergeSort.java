package recursion;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr,int left, int right){

        if(left<right){
            int mid=left +(right-left)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }

    }
    public static void merge(int[] arr,int left,int mid,int right){

        //sizes of the arrays
        int n1=mid-left+1;
        int n2=right-mid;
        //temporary array
        int[] first=new int[n1];
        int[] second=new int[n2];
        //copy data
        for(int i=0;i<n1;i++){
            first[i]=arr[left+i];
        }
        for(int i=0;i<n2;i++){
            second[i]=arr[mid+1+i];
        }

        //compare and merge
        int i=0,j=0,k=left;
        while(i<n1 && j<n2){
            if(first[i]<=second[j]){
                arr[k]=first[i++];

            }else{
                arr[k]=second[j++];
            }
            k++;
        }
        // add remaining elements
        while(i<n1){
            arr[k++]=first[i++];
        }
        while(j<n2){
            arr[k++]=second[j++];
        }
    }

    public static void main(String[] args) {

        int[] arr={1,4,6,43,6,4,3,1,6,9,6,4,2,35,7};
        int n= arr.length;
        mergeSort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));



    }
}
