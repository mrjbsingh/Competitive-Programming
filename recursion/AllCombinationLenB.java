package recursion;
import java.util.ArrayList;
import java.util.Scanner;

/*
Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.

Make sure the combinations are sorted.
Input 1:

 A = 4
 B = 2

Example Output
Output 1:

 [
  [1, 2],
  [1, 3],
  [1, 4],
  [2, 3],
  [2, 4],
  [3, 4],
 ]
 */
public class AllCombinationLenB{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        AllCombinationLenB pm = new AllCombinationLenB();
        ArrayList<ArrayList<Integer>> res = pm.combine(A, B);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
            }
            System.out.println();
        }
    }
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> finalRes = new ArrayList<>();
        for(int i=1;i<=A;i++){
            combination(i, A, B-1, res, finalRes);
        }
        
        return finalRes;
    }
    public void combination(int num, int A, int len, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> finalRes){

        res.add(num);

        if(len==0){
        
            ArrayList<Integer> temp =  new ArrayList<>(); 
            for (int j = 0; j < res.size(); j++) {
                temp.add(res.get(j));
            }
            finalRes.add(temp);
            res.remove(res.size()-1);

            return ;
        }
        else if(len>0){

            for(int i=num+1;i<=A;i++){
                combination(i, A, len-1, res, finalRes);
            }
            res.remove(res.size()-1);
            return;
        }
    }
}