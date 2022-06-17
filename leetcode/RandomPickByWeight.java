package leetcode;

import java.util.Arrays;
import java.util.Comparator;
/*
https://leetcode.com/problems/random-pick-with-weight/submissions/
 */
public class RandomPickByWeight {
    public class ProbIndex{
        public int prob;
        public int index;
    }
    ProbIndex probArr[];
    public void Solution(int[] w) {
        int n= w.length;
        probArr = new ProbIndex[n];
        int totalSum=0, val;
        for(int i=0; i<n; i++){
            totalSum += w[i];
        }
        for(int i=0; i<n; i++){
            ProbIndex temp = new ProbIndex();
            temp.prob = w[i]*10000/totalSum;
            temp.index = i;
            probArr[i] = temp;
        }
        Arrays.sort(probArr, new sortByProb());

        for(int i=1; i<n; i++){
            probArr[i].prob += probArr[i-1].prob;
        }


    }

    public int pickIndex() {
        int randomNum = (int)(Math.random()*10000);
        //System.out.println("randomNum " +randomNum);
        return binarySearchCeiling(randomNum);
    }

    public int binarySearchCeiling(int randomNum){
        int l=0, r=probArr.length-1;
        int mid;
        int ans=probArr[r].index;

        while(l<=r){

            mid = l + (r-l)/2;

            if(probArr[mid].prob == randomNum){
                return probArr[mid].index;
            }
            else if(probArr[mid].prob > randomNum){
                r = mid-1;
                ans = probArr[mid].index;

            }
            else{
                l = mid+1;
            }
        }
        return ans;
    }

    class sortByProb implements Comparator<ProbIndex> {
        public int compare(ProbIndex p1, ProbIndex p2){
            return p1.prob - p2.prob;
        }
    }
}
