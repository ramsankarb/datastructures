import java.util.ArrayList;

/**
 * Created by Ramshankar on 9/11/16.
 */
public class BubbleSort {
    public static void main(String args[])
    {
        System.out.println("Hello");

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(32);
        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(2);
        arrayList.add(22);
        for (int ran=0;ran<100;ran++)
            arrayList.add((int)(Math.random() * 120));


        System.out.println(arrayList.toString());

        System.out.println("After sorting : " + BubbleSort(arrayList));


    }

    public static ArrayList<Integer> BubbleSort(ArrayList<Integer> arrayList)
    {
        if( arrayList!=null && arrayList.size()>1){
            int arraySize = arrayList.size();
            for(int j=arraySize;j>0;j--){
                System.out.println("j "+j);
                for (int i = 0; i < j-1; i++) {
                    System.out.println("    i "+i);
                    if(arrayList.get(i)>arrayList.get(i+1)){
                        Integer temp= arrayList.get(i);
                        arrayList.set(i,arrayList.get(i+1));
                        arrayList.set(i+1, temp);

                    }
                }
            }
        }
        return arrayList;
    }
}
