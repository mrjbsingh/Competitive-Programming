import java.util.ArrayList;
import java.util.Scanner;
/*Given 4 array of integers A, B, C and D of same size, 
find and return the maximum value of 
| A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j| 
where i != j and |x| denotes the absolute value of x.
*/
public class AbsMaxMultiArr{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            B.add(sc.nextInt());
        }
        
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            C.add(sc.nextInt());
        }
       
        ArrayList<Integer> D = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            D.add(sc.nextInt());
        }
        int res;
        AbsMaxMultiArr pm = new AbsMaxMultiArr();
        res = pm.solve(A,B,C,D); 
        System.out.println(res);
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D) {
        int Xmax,Xmin;
            
            int temp, sum=0, res=Integer.MIN_VALUE;     
            for(int i=0; i<16; i++){
                Xmax= Integer.MIN_VALUE; //A[i]+i 
                Xmin= Integer.MAX_VALUE; //A[i]-i
                for(int j=0; j<A.size(); j++){  
                    sum = A.get(j);
                    for(int k=0; k<4; k++){
                        if(k==0)
                        temp= B.get(j);
                        else if(k==1)
                        temp= C.get(j);
                        else if(k==2)
                        temp= D.get(j);
                        else
                        temp= j;
                        if((i&(1<<k))!=0)
                        sum+= temp;
                        else
                        sum-= temp;
                        // System.out.print("i j k "+ i+" "+j+" "+k+" ");
                        // System.out.println((i&(1<<k)));
                    }
                    //System.out.println("i "+i+" sum "+sum);
                    Xmax =Math.max(Xmax,sum);
                    Xmin =Math.min(Xmin,sum);
                }
                System.out.println("Xmax-Xmin "+ (Xmax-Xmin));
                res = Math.max(res, Xmax-Xmin);
            }
            return res;
        }

    
}