import java.util.ArrayList;
import java.util.Scanner;

public class FlipMax{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        ArrayList<Integer> res;
        FlipMax pm = new FlipMax();
        res = pm.flip(A);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) +" ");
        }
    }
    public ArrayList<Integer> flip(String A) {
        int sum=0, ans=Integer.MIN_VALUE;
        int L=-1,R=-1; boolean flag = false;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<A.length();i++){
            if(A.charAt(i)=='0')
            {
                sum+=1;
                flag= true;
            }
            
            if(A.charAt(i)=='1')
            sum+=-1;
            if(sum>ans){
                ans=sum;
                if(L<0){
                    L=i;
                    res.add(L); res.add(L);
                   
                }
                R=i;
                if(res.size()>0 && res.get(1)<R){
                    res.set(0,L);
                    res.set(1,R);
                }
                
            } 
            if(sum<0){
                L=i+1;
                sum=0;
            }
        }
        
        if(!flag){
            return new ArrayList<Integer>();
        }
        return res;
    }
    

    
}