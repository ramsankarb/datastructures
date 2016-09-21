package arrayandstring;

/**
 * Created by Ramshankar on 9/20/16.
 * if a zero is found then moving making all the elements of that row and column to zero.
 */
public class ZeroMatrix {
    public static int[][] makeZeros(int[][] startMatrix, int n){
        //int x=n,y=n;
        int[][] finalMatrix = new int[n][n];
        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){
                if(finalMatrix[x][y]!=-1){
                    finalMatrix[x][y]=startMatrix[x][y];
                }
                if(startMatrix[x][y]==0){
                    for(int a=0;a<n;a++){
                        finalMatrix[a][y]=-1;
                        finalMatrix[x][a]=-1;
                    }
                }
            }
        }
        return finalMatrix;
    }

    public static void main(String[] args) {
        System.out.println("");
        int n=5;
        int[][] initArray= {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,0}
        };

        int[][] finalMatrix=makeZeros(initArray,n);
        for(int x=0;x<n;x++) {
            System.out.println("");
            for (int y = 0; y < n; y++) {
                System.out.print("    "+finalMatrix[x][y]);
            }
        }

    }
}
