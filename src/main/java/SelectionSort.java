import java.util.ArrayList;

/**
 * Created by Ramshankar on 9/11/16.
 */
public class SelectionSort {
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

        System.out.println("After sorting : " + selectionSort(arrayList));


    }
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> arrayList){
        int arraySize=arrayList.size();
        if(arrayList!=null &&arraySize >0){
            for (int i=0;i<arraySize;i++) {
                for(int j=i+1;j<arraySize;j++){
                    if(arrayList.get(i)>arrayList.get(j)){
                        Integer temp= arrayList.get(i);
                        arrayList.set(i,arrayList.get(j));
                        arrayList.set(j, temp);
                    }
                }

            }
        }
        return arrayList;
    }
}
