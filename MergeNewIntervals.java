import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.
 */
public class MergeNewIntervals{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("hello");

        MergeNewIntervals pm = new MergeNewIntervals();

        int size1 = sc.nextInt();
        ArrayList<Interval> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            MergeNewIntervals.Interval temp = pm.new Interval(); //innerclass object
            temp.start = sc.nextInt();
            temp.end = sc.nextInt();
            A.add(temp);
        }
        MergeNewIntervals.Interval newInterval = pm.new Interval();
            newInterval.start = sc.nextInt();
            newInterval.end = sc.nextInt();
        
        ArrayList<Interval> res;
        
        res = pm.insert(A, newInterval);
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        ArrayList<Interval> res = new ArrayList<>();
        
        int location = customBSearch(intervals, newInterval);
        System.out.println("location "+location);
        int n = intervals.size();
        int L= newInterval.start;
        int R= newInterval.end; 
        boolean isInserted = false;
        while(location>=0 && location<intervals.size()){
            if(intervals.get(location).start<= R && intervals.get(location).end >=L){
                intervals.get(location).start = Math.min(L, intervals.get(location).start);
                intervals.get(location).end = Math.max(R, intervals.get(location).end);
                isInserted = true;
                break;
            }
            else if(intervals.get(location).end < L && location+1<n && intervals.get(location+1).start > R){
                intervals.add(newInterval);
                isInserted = true;
                break;
            }
            else if(intervals.get(location).start > R && location-1>=0 && intervals.get(location-1).end < L){
                intervals.add(newInterval);
                isInserted = true;
                break;
            }
            else if(intervals.get(location).end < L){
                location++;
            }
            else if(intervals.get(location).start > R){
                location--;
            }
        }
        if(!isInserted && location<0){
            intervals.add(0, newInterval);
        }
        else if(!isInserted && location>=intervals.size()){
            intervals.add(newInterval);
        }
        return merge(intervals);
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
    public int customBSearch(ArrayList<Interval> intervals, Interval newInterval){
        int mid, ans,l,h, size=intervals.size();
        ans = 0;
        l=0; h= size-1;
        if(size==0){
            return -1;
        }
        //System.out.println("elem "+ newInterval.start);
        while(l<=h){
            mid = (h+l)/2;
            //System.out.println("l "+l+" h "+h+" mid "+mid);
            if(intervals.get(mid).start == newInterval.start){
                ans = mid;
                break;
            }
            else if(intervals.get(mid).start < newInterval.start){
                //customBSearch(a, mid+1,h, elem);
                l= mid+1;
                ans = mid;
            }
            else if(intervals.get(mid).start > newInterval.start){
                ans = intervals.get(mid).start > newInterval.start? mid-1:mid;
                h= mid-1;
            }
        }
        if(h<0) ans = intervals.get(0).start>newInterval.start? -1:0;
        else if(l>size) ans = size;
        return ans+1;
    }
}