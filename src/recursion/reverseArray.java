package recursion;

public class reverseArray {
    public static void reverseTwoPointer(int[] arr,int left,int right){
        if(left>=right) return;
        swap(arr,left,right);
        reverseTwoPointer(arr, left+1, right-1);


    }
    public static void reverseSinglePointer(int[] arr,int i,int n){
        if(i>=n/2) return;
        swap(arr,i,n-i-1);
        reverseSinglePointer(arr,i+1,n);
    }
    public static void swap(int[] arr, int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,2};
        reverseArray.reverseTwoPointer(arr,0,4);
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();

        int[] arr1={5,4,3,2,1};
        reverseSinglePointer(arr1,0,5);
        for(int i:arr1){
            System.out.print(i+" ");
        }
    }

}
