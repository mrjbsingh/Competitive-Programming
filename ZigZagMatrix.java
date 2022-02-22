import java.util.ArrayList;
import java.util.Scanner;

public class ZigZagMatrix{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        ArrayList<ArrayList<Integer>> res;
        ZigZagMatrix pm = new ZigZagMatrix();
        res = pm.generateMatrix(A);
        pm.print2DArray(res);
    }
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        int k=1;
        for(int i=0;i<A; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<A; j++){
                row.add(k);
                if(i%2==0){
                    k++;
                }else if(i%2==1){
                    k--;
                }
            }
            arr.add(row);
            if(i%2==0){
                k= row.get(A-1)+A;//(k-1) + A;
            }else if(i%2==1){
                k= row.get(0)+1;//(k+1) + 2*A;
            }
            
        }
    return arr;
    }
    
    void print2DArray(ArrayList<ArrayList<Integer>> A){
        for(int i=0;i<A.size();i++){
              for(int j=0;j<A.get(i).size();j++){
                  System.out.print(A.get(i).get(j)+" ");
              }
              System.out.println("\n\n");
          } 
    }
    
}