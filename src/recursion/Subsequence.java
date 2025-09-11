package recursion;

import java.util.ArrayList;
import java.util.List;
//subsequence means contiguous or non contiguos parts of an array or string
//        eg, {3,2,1} -> [3,2],[3,1],[2,1] are valid but [1,3] is not valid
public class Subsequence {
    public static void printSubsequences(int[] arr,int idx, List<Integer> current){
        if(idx== arr.length){
            System.out.println(current);
            return;
        }
        // at every step we have 2 options-> to include or not include the current element
        current.add(arr[idx]); //include the current element
        printSubsequences(arr,idx+1,current);

        current.remove(current.size()-1); //is important because it restores the state of your current list after exploring one recursive choice.
        printSubsequences(arr,idx+1,current);// exclude current

    }

    public static void main(String[] args) {

        int[] arr={3,2,1};
        List<Integer> list=new ArrayList<>();
        printSubsequences(arr,0,list);

    }
}
