import java.util.ArrayList;
import java.util.Scanner;

/*Given an unsorted integer array A of size N. 
Find the first missing positive integer.

Note: Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingPositive{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        int res;
        FirstMissingPositive ba = new FirstMissingPositive();
        res = ba.solve(A);
        System.out.println("res "+res);
    }
   
    public int solve(ArrayList<Integer> A) {
        int temp,index, count=0;
        for(int i=0;i<A.size();i++){
            
                while(i!=A.get(i)-1){
                index = A.get(i);
                if(index>=1 && index<=A.size()){
                    temp = A.get(A.get(i)-1);
                    if(temp==A.get(i))
                        break;
                    A.set(A.get(i)-1,A.get(i));
                    A.set(i,temp);
                    count++;
                }
                else{
                    break;
                }
            }
        }
        int i=0;
         for(i=0;i<A.size();i++){
                if(i+1!=A.get(i)){
                    break;
                }
            }
        return (i+1);
    }

}