package dynamicprograming;
/*
Given a 2D integer array A of size N * N representing a triangle of numbers.

Find the maximum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

NOTE:

Adjacent cells to cell (i,j) are only (i+1,j) and (i+1,j+1)
Row i contains i integer and n-i zeroes for all i in [1,n] where zeroes represents empty cells.
 */
public class MaxPathTriangle {
    public int solve(int[][] arr) {
        int n = arr.length;
        for(int i = n-2; i>=0 ; i--){
            for(int j=0; j<=i; j++){
                if(i+1<=n && j+1<=n)
                    arr[i][j] += Math.max(arr[i+1][j], arr[i+1][j+1]);
            }
        }

        return arr[0][0];
    }
}
