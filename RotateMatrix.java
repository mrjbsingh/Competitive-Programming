import java.util.ArrayList;
import java.util.Scanner;

public class RotateMatrix{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < size1; j++) {
                row.add(sc.nextInt());
            }
            A.add(row);
        }
       
        RotateMatrix pm = new RotateMatrix();
        pm.solve(A);
        pm.print2DArray(A); 
        //System.out.println(res);
    }
    public void solve(ArrayList<ArrayList<Integer>> A) {
        int temp;
        for(int i=0;i<A.size();i++){
          //ArrayList<Integer> row = A.get(i);
            for(int j=0;j<i;j++){
                temp= A.get(i).get(j);
                A.get(i).set(j, A.get(j).get(i)) ;
                A.get(j).set(i, temp);
            }
        }
         for(int i=0;i<A.size();i++){
          
            for(int j=0, k=A.size()-1;j<A.size()/2;j++,k--){
                temp= A.get(i).get(j);
                A.get(i).set(j,A.get(i).get(k));
                A.get(i).set(k,temp);
            }
        }
    }

    void print2DArray(ArrayList<ArrayList<Integer>> A){
        for(int i=0;i<A.size();i++){
              for(int j=0;j<A.get(i).size();j++){
                  System.out.print(A.get(i).get(j)+" ");
              }
              System.out.println();
          } 
    }
    
}