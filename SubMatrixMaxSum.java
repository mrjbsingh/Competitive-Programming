import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class SubMatrixMaxSum{
    public static void main(String[] args) throws IOException{
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < size2; j++) {
                
                row.add(sc.nextInt());
            }
            A.add(row);
        }
        int B = sc.nextInt();
        SubMatrixMaxSum pm = new SubMatrixMaxSum();
        int res = pm.solve(A, B);
        System.out.println(res);
       
    }
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> sumMatrix = new ArrayList<>();
        int r1,c1,r2,c2;
        int sum =0;
        
        for(int i=0; i<A.size(); i++){
                ArrayList<Integer> row = new ArrayList<>();
                for(int j=0; j<A.get(i).size(); j++){
                     row.add(sum);
                }
                sumMatrix.add(row); 
            }
        for(int i=0; i<A.size(); i++){
                
                for(int j=0; j<A.get(i).size(); j++){
                    // sum = addWithMod((A.get(i).get(j), returnElement(sumMatrix,i,j-1));
                    // sum = addWithMod(sum, returnElement(sumMatrix,i-1,j));
                    // sum = subWithMod(sum, returnElement(sumMatrix,i-1,j-1));
                    sum = A.get(i).get(j)+ returnElement(sumMatrix,i,j-1)+ returnElement(sumMatrix,i-1,j) - returnElement(sumMatrix,i-1,j-1);
                    sumMatrix.get(i).set(j,sum);
                }
            }
            print2DArray(sumMatrix);
        int res = Integer.MIN_VALUE;
        for(int i=0; i+B <=A.size(); i++){
            for(int j=0; j+B <=A.size(); j++){
            r1 = i; c1 = j;
            r2 = i+B-1; c2 = j+B-1;
            System.out.println("r1 c1 "+ r1+" "+c1);
            System.out.println("r2 c2 "+ r2+" "+c2);
            // ans = subWithMod(returnElement(sumMatrix,r2,c2), returnElement(sumMatrix,r2,c1-1));
            // ans = subWithMod(ans, returnElement(sumMatrix,r1-1,c2));
            // ans = addWithMod(ans, returnElement(sumMatrix,r1-1,c1-1));
            sum = returnElement(sumMatrix,r2,c2) -returnElement(sumMatrix,r2,c1-1) -returnElement(sumMatrix,r1-1,c2) +returnElement(sumMatrix,r1-1,c1-1);
            System.out.println("sum "+ sum);
            res = res<sum? sum: res; 
            }
        }
        return res;
        }


        public int returnElement(ArrayList<ArrayList<Integer>> sumMatrix, int i ,int j){
            
            if(i>=0&&j>=0 && i<sumMatrix.size()&& j<sumMatrix.get(i).size()){
                return sumMatrix.get(i).get(j);
            }
            else{
                return 0;
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

    String str2DArray(ArrayList<ArrayList<Integer>> A){
        String text="";
        for(int i=0;i<A.size();i++){
              for(int j=0;j<A.get(i).size();j++){
                  text +=A.get(i).get(j)+" ";
              }
          } 
        return text;
    }
    
}