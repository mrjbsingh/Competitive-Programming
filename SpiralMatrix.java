import java.util.ArrayList;
import java.util.Scanner;

public class SpiralMatrix{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        ArrayList<ArrayList<Integer>> res;
        SpiralMatrix pm = new SpiralMatrix();
        res = pm.generateMatrix(A);             
        pm.print2DArray(res);                               
    }
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        //ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        int k=1;
        int arr[][] =new int[A][A];
        for(int i=0;i<A; i++){
            
            for(int j=i;j<A-i; j++){
                System.out.println("i j k "+i+" "+j+" "+k);
               arr[i][j]=k;
               k++;
            }
            for(int j=i+1;j<A-i; j++){ System.out.println("i j k "+j+" "+(A-1-i)+" "+k);
                arr[j][A-1-i]=k;
                k++;
             }
             for(int j=A-2-i;j>=i; j--){ System.out.println("i j k "+(A-1-i)+" "+j+" "+k);
                arr[A-1-i][j]=k;
                k++;
             } 
             for(int j=A-2-i;j>i; j--){ System.out.println("i j k "+j+" "+i+" "+k);
                arr[j][i]=k;
                k++;
             } 
           
        }
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return new ArrayList<ArrayList<Integer>>();
    }
    
    void print2DArray(ArrayList<ArrayList<Integer>> A){
        System.out.println("hellllllll");
        for(int i=0;i<A.size();i++){
              for(int j=0;j<A.get(i).size();j++){
                  System.out.print(A.get(i).get(j)+" ");
              }
              System.out.println("\n\n");
          } 
    }
    
}