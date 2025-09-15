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

    public static int countSubsWithSumK(int[] arr,int idx,int s,int sum){
        if(s>sum) return 0;
        if(idx==arr.length){
            if(s==sum){
                return 1;
            }
            else return 0;
        }

        s+=arr[idx];
        int left= countSubsWithSumK(arr,idx+1,s,sum);
        s-=arr[idx];
        int right=countSubsWithSumK(arr,idx+1,s,sum);

        return left+right;
    }
    public static void main(String[] args) {

        int[] arr={1,2,1,2,0};
        int sum=2;
        List<Integer> list=new ArrayList<>();
        subsWithSumK(arr,list,0,0,sum);
        System.out.println(countSubsWithSumK(arr,0,0,sum));

    }
}
