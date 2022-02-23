import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
Given a vector A of non-negative integers representing an elevation map 
where the width of each bar is 1, compute how much water it is able to 
trap after raining.
 */
public class MergeIntervals{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("hello");

        MergeIntervals pm = new MergeIntervals();

        int size1 = sc.nextInt();
        ArrayList<Interval> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            MergeIntervals.Interval temp = pm.new Interval(); //innerclass object
            temp.start = sc.nextInt();
            temp.end = sc.nextInt();
            A.add(temp);
        }
        
        ArrayList<Interval> res;
        
        res = pm.merge(A);
        pm.printIntervals(res);
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