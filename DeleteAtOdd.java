import java.util.Scanner;
/*
Given an integer A which denotes the number of people standing in the queue.

A selection process follows a rule where people standing on even positions 
are selected. Of the selected people a queue is formed and again out of these 
only people on even position are selected.

This continues until we are left with one person. 
Find and return the position of that person in the original queue.
 */
public class DeleteAtOdd{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
       
        int res;
        DeleteAtOdd pm = new DeleteAtOdd();
        res = pm.solve(size1);
        
        System.out.print(res);
        
    }
    public int solve(int A) {
        int ans=1;
        while(ans<A){
            ans*=2;
        }
        if(ans==A) return ans;
        else 
        return ans/2;
    }
    
}