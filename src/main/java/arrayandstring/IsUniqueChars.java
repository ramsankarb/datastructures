package arrayandstring;

import java.util.HashMap;

/**
 * Created by Ramshankar on 9/18/16.
 * Given string find if it has repeating characters.
 */
public class IsUniqueChars {

    public static boolean isUnique(String str)
    {
        char[] array = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c:array){
            if(map.get(c)!=null && map.get(c)==1) {
                return false;
            }
            else {
                map.put(c, 1);
            }
        }

        return true;
    }

    public static boolean isUniqueMethod2(String str)
    {
        if(str.length() >128){ return false;}

        boolean[] booArray= new boolean[128];
        for(int i=0;i<str.length();i++){
            if(booArray[str.charAt(i)]){
                return false;
            }
            else {
                booArray[str.charAt(i)]=true;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println("IsUnique : " + isUnique("Ram"));
        System.out.println("IsUnique : " + isUnique("Rama"));
        System.out.println("IsUnique : " + isUnique("aa"));
        System.out.println("IsUnique : " + isUnique(""));

        System.out.println("IsUnique : " + isUniqueMethod2("Ram"));
        System.out.println("IsUnique : " + isUniqueMethod2("Rama"));
        System.out.println("IsUnique : " + isUniqueMethod2("aa"));
        System.out.println("IsUnique : " + isUniqueMethod2(""));
    }

}
