package sorting;

import java.util.ArrayList;

/**
 * Created by Ramshankar on 9/11/16.
 */
public class InsertionSort {
    public static void main(String args[])
    {
        System.out.println("Hello");

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        arrayList.add(32);
        arrayList.add(1);
        arrayList.add(12);
        arrayList.add(2);
        arrayList.add(22);
        for (int ran=0;ran<10;ran++)
            arrayList.add((int)(Math.random() * 120));


        System.out.println(arrayList.toString());

        System.out.println("After sorting : " + insertionSort(arrayList));


    }
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> arrayList){
        int arraySize=arrayList.size();
        ArrayList<Integer> sortedList = new ArrayList<Integer>();

        if(arrayList!=null &&arraySize >0){
            for (int i=0;i<arraySize;i++) {
                int j=0;
                sortedList.add(0);
                int sorSize=sortedList.size()-1;
                for(j=sorSize;j>0;j--){
                    if(j!=0 && arrayList.get(i)<sortedList.get(j-1)){
                        System.out.println(j);
                        sortedList.set(j,sortedList.get(j-1));
                    }
                    else{
                        break;
                    }
                }
                sortedList.set(j, arrayList.get(i));
            }
        }
        return sortedList;
    }
}
