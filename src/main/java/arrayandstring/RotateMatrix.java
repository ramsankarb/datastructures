package arrayandstring;

/**
 * Created by Ramshankar on 9/20/16.
 * rotate a given matrix to 90 degree
 */
public class RotateMatrix {
    public static int[][] rotateMatrix(int[][] charMatrix, int n){

        int[][] finalMatrix= new int[n][n];
        int x,y;
        for(x=0;x<n;x++){
            for(y=0;y<n;y++){
                finalMatrix[y][n-x-1] = charMatrix[x][y];
                System.out.println("  "+finalMatrix[y][n-x-1]);
            }
        }

        return finalMatrix;
    }

    public static void main(String[] args) {
        int n=5;
        int[][] charMatrix= {
            {1,2,3,4,5},
            {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
//        charMatrix=[]
        int[][] finalMatrix= rotateMatrix(charMatrix,n);

        for(int x=0;x<n;x++){
            System.out.println("------------");
            for(int y=0;y<n;y++){
                System.out.print("  "+finalMatrix[x][y]);
            }
        }

    }
}
