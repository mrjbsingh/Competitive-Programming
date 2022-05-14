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

    public class Interval{
        int start;
        int end;
    
        public Interval(){
            start=0;
            end=0;
        }
        public Interval(int s, int e){
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        ArrayList<Interval> res = new ArrayList<>();
        
        Collections.sort(intervals, new IntervalComparator());
        
        int L=intervals.get(0).start;
        int R=intervals.get(0).end;
        for(int i=1; i<intervals.size(); i++){
            if(intervals.get(i).start <= R){
                R = Math.max(R, intervals.get(i).end);
            }
            else{
                Interval temp = new Interval(L,R);
                res.add(temp);
                L=intervals.get(i).start;
                R=intervals.get(i).end;
            }
        }
        Interval temp = new Interval(L,R);
        res.add(temp);

        return res;
    }
    class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
            if(i1.start == i2.start){
                return 0;
            }
            else if(i1.start > i2.start)
                return 1;
            else
                return -1;
        }
    }
    public void printIntervals(ArrayList<Interval> A){
        for(int i=0; i<A.size(); i++){
            System.out.println(A.get(i).start +" "+ A.get(i).end);
        }
    }
}