import java.util.ArrayList;
import java.util.Scanner;

public class ClosestMinMax{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        int res;
        ClosestMinMax pm = new ClosestMinMax();
        res = pm.solve(A);
        System.out.println(res);
    }
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(A.get(i)>=max){
                max = A.get(i);
            }
            if(A.get(i)<=min){
                min = A.get(i);   
            }
        }
        ArrayList<Integer> maxInd = new ArrayList<>();
        ArrayList<Integer> minInd = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(A.get(i)==max){
                maxInd.add(i);
            }
            if(A.get(i)==min){
                minInd.add(i);   
            }
        }
        int dist=Integer.MAX_VALUE;
        for(int i=0; i<maxInd.size(); i++){
            for(int j=0; j<minInd.size(); j++){
                dist = dist>Math.abs(maxInd.get(i)-minInd.get(j))? Math.abs(maxInd.get(i)-minInd.get(j)):dist;
            }
        }
    return dist+1;
    }
}