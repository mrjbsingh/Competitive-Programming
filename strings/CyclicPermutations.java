package strings;
import java.util.Scanner;
/*
You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.

Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.
*/
public class CyclicPermutations{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        
        CyclicPermutations pm = new CyclicPermutations();
        int res = pm.solve(A, B);
        
        System.out.print(res);
        
    }
    public int solve(String A, String B) {
        String mergedStr = A+"#"+B+B;
        
        int z[] = getZAlgoValue(mergedStr);
        int count=0;
        for(int i=1; i<z.length; i++){
            if(z[i]==A.length()){
                count++;
            }
        }
        if(A.equals(B))
            return count-1;
        return count;
    }
    public int[] getZAlgoValue(String A){
        int n = A.length();
        int z[] = new int[n];
        int L=0,R=0;
        for(int i=1; i<n ;i++){
            
            if(i>R){
                L=i; R=i;
                while(R<n && A.charAt(R) == A.charAt(R-L)){
                    R++;
                }
                z[i]=R-L; R--;
            }
            else{
                if( i+ z[i-L]<=R){
                    z[i] = z[i-L];
                }
                else{
                    L=i;
                    while(R<n && A.charAt(R) == A.charAt(R-L)){
                        R++;
                    }
                    z[i]=R-L; R--;
                }
            }
        }
        return z;
    }
}