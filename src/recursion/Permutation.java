package recursion;

//46. Permutations
//        Solved
//Medium
//        Topics
//premium lock icon
//        Companies
//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
//
//
//        Example 1:
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//Example 2:
//
//Input: nums = [0,1]
//Output: [[0,1],[1,0]]
//Example 3:
//
//Input: nums = [1]
//Output: [[1]]
//
//
//Constraints:
//
//        1 <= nums.length <= 6
//        -10 <= nums[i] <= 10
//All the integers of nums are unique.

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void backtrack(int[] arr, List<Integer> list, List<List<Integer>> ans){
        if(list.size()==arr.length){
            ans.add(new ArrayList<>(list));
        }
        for(int i=0;i<arr.length;i++){
            if(list.contains(arr[i])) continue;
            list.add(arr[i]);
            backtrack(arr,list,ans);
            list.remove(list.size()-1);

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] nums= {1,2,3};
        backtrack(nums,new ArrayList<>(),ans);
        System.out.println(ans);
    }
}
