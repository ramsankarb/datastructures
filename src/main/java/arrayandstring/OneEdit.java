package arrayandstring;

/**
 * Created by Ramshankar on 9/19/16.
 * return true if the two string just one edit away. edit is delete add or replace.
 *
 */
public class OneEdit {

    public static boolean isOneEdit(String str1, String str2){

        if(str1.length()-str2.length()>1||str1.length()-str2.length()<-1){
            return false;
        }
        int changeCount1=0,changeCount2=0,equalCount=0;
        for(int i=0;i<str1.length()-1;i++){
                if(str1.charAt(i+changeCount1)!=str2.charAt(i+changeCount2)){
                    System.out.println(str1.charAt(i+changeCount1)+" "+str2.charAt(i+changeCount2)+" "+(str1.length()> str2.length()));
                    if(changeCount1==-1 || changeCount2==-1 ||equalCount==-1){
                        return false;
                    }
                    else{
                        if(str1.length()> str2.length()){
                            changeCount2=-1;
                        }
                        else
                        {
                            if(str1.length() == str2.length()){
                                equalCount=-1;
                            }else {
                                changeCount1 = -1;
                            }
                        }
                    }
                }
        }

    return true;
    }

    public static void main(String[] args) {
        System.out.println(" " + isOneEdit("12342222","234561"));
        System.out.println(" " + isOneEdit("1234","234561"));
        System.out.println(" " + isOneEdit("pale","ple"));
        System.out.println(" " + isOneEdit("pales","pale"));
        System.out.println(" " + isOneEdit("pale","bale"));
        System.out.println(" " + isOneEdit("pale","bake"));
    }
}
