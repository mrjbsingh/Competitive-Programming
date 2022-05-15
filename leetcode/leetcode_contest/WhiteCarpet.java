package leetcode.leetcode_contest;
import java.util.*;

/*
Given a collection of intervals, merge all overlapping intervals.
 */
public class WhiteCarpet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("hello");

        WhiteCarpet pm = new WhiteCarpet();

        //int size1 = sc.nextInt();
        int tiles[][] = {{1,5},{10,11},{20,25},{30,32},{12,18}};
        
        int res;
        
        res = pm.maximumWhiteTiles(tiles, 10);
        System.out.println(res);
    }
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        //Collections.sort(tiles, new IntervalComparator());
        Arrays.sort(tiles, new Sort2dArr(0));
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                System.out.print(tiles[i][j]+",");
            }
            System.out.println();
        }

        return 0;
    }
    class Sort2dArr implements Comparator<int []>{
        int column;
        Sort2dArr(int column){
            this.column = column;
        }
        public int compare(final int entry1[], final int entry2[]){
            if(entry1[column]> entry2[column]){
                return 1;
            }
            else
                return -1;
        }
    }

}