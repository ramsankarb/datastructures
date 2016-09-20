package arrayandstring;

/**
 * Created by Ramshankar on 9/19/16.
 * Tocheck if the given string is palindrome after the permutation.
 * Looks like the below is best solutoin. O(n)
 *
 */
public class PalindromePermutation {

    public static boolean isPalindrome(String str){
        boolean[] booArray = new boolean[128];
        int falseCount=0,trueCount = 0;

        for(int i=0; i< str.length();i++){
            if(booArray[str.charAt(i)]){
                booArray[str.charAt(i)]=false;
                falseCount+=1;
            }else{
                booArray[str.charAt(i)]=true;
                trueCount+=1;
            }
        }

        if((trueCount-falseCount)>2){
            return false;
        }else{
            return true;
        }

    }

    public static boolean isPalindromeWith01(String str){
        int[] intArray = new int[128];
        int falseCount=0,trueCount = 0;

        for(int i=0; i< str.length();i++){

            if( intArray[str.charAt(i)]==0){
                intArray[str.charAt(i)]=1-intArray[str.charAt(i)];
                trueCount+=1;
            }else{
                intArray[str.charAt(i)]=1-intArray[str.charAt(i)];
                falseCount+=1;
            }
            //System.out.println(i+" " + intArray[str.charAt(i)] + " " + trueCount + " " + falseCount);
        }

        if((trueCount-falseCount)>2){
            return false;
        }else{
            return true;
        }

    }


    public static void main(String[] args) {
        System.out.println("isPalindrome  " + isPalindrome("12321"));
        System.out.println("isPalindrome  " + isPalindrome("taco cat"));
        System.out.println("isPalindrome  " + isPalindrome("1"));
        System.out.println("isPalindrome  " + isPalindrome("12"));
        System.out.println("isPalindrome  " + isPalindrome("123"));

        System.out.println("isPalindrome  " + isPalindromeWith01("12321"));
        System.out.println("isPalindrome  " + isPalindromeWith01("taco cat"));
        System.out.println("isPalindrome  " + isPalindromeWith01("1"));
        System.out.println("isPalindrome  " + isPalindromeWith01("12"));
        System.out.println("isPalindrome  " + isPalindromeWith01("123"));

    }

}
