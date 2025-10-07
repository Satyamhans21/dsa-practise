package recursion;

//131. Palindrome Partitioning
//Solved
//        Medium
//Topics
//premium lock icon
//        Companies
//Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//
//
//
//        Example 1:
//
//Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
//Example 2:
//
//Input: s = "a"
//Output: [["a"]]
//
//
//Constraints:
//
//        1 <= s.length <= 16
//s contains only lowercase English letters.
//
//
//Seen this question in a real interview before?
//        1/5
//Yes
//        No
//Accepted
//1,213,925/1.7M
//Acceptance Rate
//73.0%

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s){
        List<List<String>> res =new ArrayList<>();
        List<String> path=new ArrayList<>();
        backtrack(0,s,path,res);
        return res;
    }
    public static void backtrack(int index,String s,List<String> path,List<List<String>> res){
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                backtrack(i+1,s,path,res);
                path.remove(path.size()-1);

            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end){

        while(start<=end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;

    }

    public static void main(String[] args) {
        List<List<String>> result = partition("aab");
        System.out.println(result);

    }

}
