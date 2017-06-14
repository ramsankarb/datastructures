package sorting;

/**
 * Created by Ramshankar on 9/25/16.
 */
public class MergeSort {
    public static int[] toMergeSort(int[] a, int s,int n){
        System.out.println(s+" "+n);
        if((n-s)>=2){
            int mid=(n-s+1)%2==0?s+((n-s)/2):s+((n-s)/2);
            System.out.println(mid+" "+s+" "+n);
            int[] leftSorted = toMergeSort(a, (s), mid);
            int[] rightSorted = toMergeSort(a, mid+1, n);

            int[] finalSorted = merge(leftSorted,rightSorted,s,mid,n);
            System.out.println("After Final sort");
            toPrint(finalSorted);
            return finalSorted;
        }else{
            System.out.println(" Inside sort "+s+" "+n);
            if(n-s==1){
                if(a[s-1]>a[n-1]){
                    int temp= a[s-1];
                    a[s-1] = a[n-1];
                    a[n-1] = temp;
                }
            }
            toPrint(a);
            return a;
        }
    }

    public static int[] merge(int[] a, int[] b, int s, int mid, int n){
        //int maxALen = a.length;
        //int maxBLen = b.length;
        int aPointer=s-1,bPointer=mid,currentPointer=s-1;
        int[] mergedArray = a.clone();
        System.out.println("Inside merge " + s +" " + mid + " " +n);
        toPrint(a);
        toPrint(b);
        do{
            System.out.println((a[aPointer]<b[bPointer])+" " +a[aPointer]+" "+b[bPointer]);
            if(a[aPointer]<=b[bPointer]){
                mergedArray[currentPointer] = a[aPointer];
                aPointer++;
            }else{
                mergedArray[currentPointer] = b[bPointer];
                bPointer++;
            }
            toPrint(mergedArray);
            currentPointer++;
        }while(aPointer!=mid && bPointer!=n);
        System.out.println("After merge "+(aPointer==mid && bPointer==n));
        toPrint(mergedArray);
        return mergedArray;
    }

    public static void main(String args[]){
        int[] inputArray = {6,7,5,8,3,9};
        toPrint(toMergeSort(inputArray, 1, inputArray.length));
    }

    public static void toPrint(int[] array){
        for(int i=0; i< array.length; i++){
            System.out.print("  " + array[i]);
        }
        System.out.println();
    }
}
