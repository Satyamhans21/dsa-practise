package recursion;

public class Palindrome {
    public static boolean checkPalindrome(char[] arr,int i, int n){
        if(i>=n/2) return true;
        if(arr[i]!=arr[n-i-1]) return false;
        return checkPalindrome(arr,i+1,n);

    }
    public static void main(String[] args) {
        String str="madame";
        int n=str.length();
        char[] arr=str.toCharArray();
        System.out.println(checkPalindrome(arr,0,n));

    }
}
