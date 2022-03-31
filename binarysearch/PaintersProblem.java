package binarysearch;
import java.util.ArrayList;
import java.util.Scanner;
/*
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.
*/
public class PaintersProblem{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int size1 = sc.nextInt();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            C.add(sc.nextInt());
        }
        
    
        PaintersProblem pm = new PaintersProblem();
        int res = pm.paint(A, B, C); 
        
        System.out.println(res);
        
        
    }
    
    public int paint(int A, int B, ArrayList<Integer> C) {
        long l,r, m=-1, max=-1, sum=0;
        
        for(int i=0; i<C.size(); i++){
            max = max>C.get(i) ? max : C.get(i);
            sum += C.get(i); 
        }
        l= max*B;
        r= sum*B;
        long cnt=1;
        while(l<=r){
            //System.out.println("l "+l + " r "+ r);
            m = l+ (r-l)/2;
            cnt = countPainter(m, B, C);
            //System.out.println("m "+m + " cnt "+ cnt);
            if(cnt==(long)A && countPainter(m-1, B, C)>(long)A){
                return (int)(m%10000003);
            }
            if(cnt<=A){
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        if(cnt <= (long)A)
            return (int)(m%10000003);   
        else
            return -1;
    }
    long countPainter(long maxTime, int B, ArrayList<Integer> C){
         long cnt=1, sum=0;
        for(int i=0; i<C.size(); i++){
            long temp = C.get(i);
            temp= temp*B;
            
            if(sum+temp<=maxTime){
                sum+= temp;
            }
            else{
                cnt++;
                sum=temp;
            }
        }
        return cnt;
    }
    
}