package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceWithSumK {
    public static void subsWithSumK(int[] arr, List<Integer> list, int idx, int s,int sum){
        if(idx== arr.length){
            if(s==sum) {
                System.out.println(list);
            }
            return;
        }
        list.add(arr[idx]);
        s+=arr[idx];
        subsWithSumK(arr,list,idx+1,s,sum);
        int removed=list.remove(list.size()-1);
        s-=removed;
        subsWithSumK(arr,list,idx+1,s,sum);
    }
    public static void main(String[] args) {

        int[] arr={1,2,1,2,4,6,87,4,6,4,6,8,3,1,3,6,9,0,4};
        int sum=5;
        List<Integer> list=new ArrayList<>();
        subsWithSumK(arr,list,0,0,sum);

    }
}
