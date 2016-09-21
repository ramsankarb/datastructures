package arrayandstring;

/**
 * Created by Ramshankar on 9/20/16.
 */
public class StringCompression {
    public static String stringCompress(String str){
        char[] finalChars = new char[str.length()];
        StringBuffer stringBuffer = new StringBuffer();
        char c='\0';
        int charCount=0,charPointer;
        for(int i=0;i<str.length();i++){


            if(c==str.charAt(i)){
                charCount+=1;
            }else if(c!='\0'){
                //reset
                stringBuffer.append(charCount);
                charCount=0;
                c='\0';
            }

            if(c=='\0') {
                c = str.charAt(i);
                charCount=1;
                stringBuffer.append(c);
            }
        }
        stringBuffer.append(charCount);
        if(str.length()<stringBuffer.length()) {
           return str;
        }else{
            return stringBuffer.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(" -------- " + stringCompress("qqwweeerr"));
        System.out.println(" -------- " + stringCompress("aaaassssddddddddddddddddddddffffff"));
        System.out.println(" -------- " + stringCompress("qwertyuiiiiiiiiii"));
    }
}
