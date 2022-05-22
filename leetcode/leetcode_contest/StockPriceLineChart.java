package leetcode.leetcode_contest;

import java.util.Arrays;
import java.util.Comparator;
/*
https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/
 */
public class StockPriceLineChart {
    public int minimumLines(int[][] stockPrices) {
        int n = stockPrices.length;
        if(n==1)
            return 0;
        Arrays.sort(stockPrices, new Sort2dArr(0));
        long previousY = (long)stockPrices[1][1]- (long)stockPrices[0][1];
        long previousX = (long)stockPrices[1][0]- (long)stockPrices[0][0];
        //Double lastSlope = y/x;
        int count=1;
        if(n==2)
            return count;
        for(int i=2; i<n; i++){
            //System.out.print(stockPrices[i][0]+" ");
            long y = (long)stockPrices[i][1]- (long)stockPrices[i-1][1];
            long x = (long)stockPrices[i][0]- (long)stockPrices[i-1][0];

            if(previousY*x !=previousX*y){
                //System.out.print(" inside ");
                count++;
                previousY = y;
                previousX = x;
            }

        }
        return count;
    }
    public class Sort2dArr implements Comparator<int []> {
        int column;
        Sort2dArr(int column){
            this.column = column;
        }
        public int compare(final int entry1[], final int entry2[]){
            if(entry1[column]>= entry2[column]){
                return 1;
            }
            else
                return -1;
        }
    }
}
