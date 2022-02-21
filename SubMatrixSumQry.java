import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class SubMatrixSumQry{
    public static void main(String[] args) throws IOException{
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        String text="";
 
        // Defining the file name of the file
        Path fileName = Path.of(
            "/home/jayendrasingh/code/cp/demo.txt");

        int size1 = 490;//sc.nextInt();
        int size2 = 290;//sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < size2; j++) {
                row.add(i*j);
                //row.add(sc.nextInt());
            }
            A.add(row);
        }
       
        SubMatrixSumQry pm = new SubMatrixSumQry();
        //ArrayList<Integer> res = pm.solve(A);
        text = pm.str2DArray(A); 
        //System.out.println(res);
        // Writing into the file
        Files.writeString(fileName, text);
    }
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        ArrayList<ArrayList<Long>> sumMatrix = new ArrayList<>();
        int r1,c1,r2,c2;
        long sum =0;
        long M = 1000000007;
        for(int i=0; i<A.size(); i++){
                ArrayList<Long> row = new ArrayList<>();
                for(int j=0; j<A.get(i).size(); j++){
                     row.add(sum);
                }
                sumMatrix.add(row); 
            }
        for(int i=0; i<A.size(); i++){
                
                for(int j=0; j<A.get(i).size(); j++){
                    sum = addWithMod((long)A.get(i).get(j), returnElement(sumMatrix,i,j-1));
                    sum = addWithMod(sum, returnElement(sumMatrix,i-1,j));
                    sum = subWithMod(sum, returnElement(sumMatrix,i-1,j-1));
                    //sum = (A.get(i).get(j)%M+ ((returnElement(sumMatrix,i,j-1)%M+ returnElement(sumMatrix,i-1,j)%M)%M - returnElement(sumMatrix,i-1,j-1)%M)%M)%M;
                    sumMatrix.get(i).set(j,sum%M);
                }
            }
        long ans=0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<B.size(); i++){
            r1 = B.get(i)-1; c1 = C.get(i)-1;
            r2 = D.get(i)-1; c2 = E.get(i)-1;
            ans = subWithMod(returnElement(sumMatrix,r2,c2), returnElement(sumMatrix,r2,c1-1));
            ans = subWithMod(ans, returnElement(sumMatrix,r1-1,c2));
            ans = addWithMod(ans, returnElement(sumMatrix,r1-1,c1-1));
            //ans = (((returnElement(sumMatrix,r2,c2)%M -returnElement(sumMatrix,r2,c1-1)%M)%M -returnElement(sumMatrix,r1-1,c2)%M)%M +returnElement(sumMatrix,r1-1,c1-1)%M)%M;
            res.add((int)ans);
        }
        return res;
        }
        public long returnElement(ArrayList<ArrayList<Long>> sumMatrix, int i ,int j){
            long M = 1000000007;
            if(i>=0&&j>=0 && i<sumMatrix.size()&& j<sumMatrix.get(i).size()){
                return sumMatrix.get(i).get(j)%M;
            }
            else{
                return 0;
            }
        }
        public long addWithMod(Long a, Long b){
            long M = 1000000007;
            return (a+b)%M;
        }
        public long subWithMod(Long a, Long b){
            long M = 1000000007;
            return ((a-b)%M+M)%M;
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