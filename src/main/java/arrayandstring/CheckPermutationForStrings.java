package arrayandstring;



/**
 * Created by Ramshankar on 9/18/16.
 * Given two strings check if one string is the permutation of the other.
 */
public class CheckPermutationForStrings {

    public static boolean isPermutationOfStrings(String str1, String str2){

        boolean[] booArray = new boolean[128];

        for( int i=0;i<str1.length();i++){
            booArray[str1.charAt(i)] = true;
        }

        for( int i=0;i<str2.length();i++){
            if(!booArray[str2.charAt(i)] )
            {
                return false;
            }
        }

        return true;

    }


        public static void main(String[] args) {
        System.out.println(isPermutationOfStrings("ram", "mar"));
        System.out.println(isPermutationOfStrings("sram","rams"));
        System.out.println(isPermutationOfStrings("ram1", "mar12"));
        System.out.println(isPermutationOfStrings("ram",""));
        System.out.println(isPermutationOfStrings("2123", "mar"));
        System.out.println(isPermutationOfStrings("sram","rams"));
    }

}
