import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ReverseConc{
    HashMap<String, Integer> hMap = new HashMap<>();
    public static void main(String[] args) {
        //System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        //System.out.println("res "+ (-97)%2);
        
        //int C = Integer.MIN_VALUE
        // Set<Integer> hs=new HashSet();
        
        ArrayList<Integer> res= new ArrayList<>();
       // ReverseConc pm = new ReverseConc();
        //res = pm.pow(A,B);
        // for (int i = 0; i < res.size(); i++) {
        //     System.out.print(res.get(i) +" ");
        // }
            res.add(0);
        for(int i=1; i<=100;i++){
            res.add(i);
        }
        int i=0;
        char y ;
        while(res.size()>=1){
            
            System.out.println("killed "+res.remove(i));
            res.remove(i);
            i++;
            if(i==25){
                break;
            }
        }
    }
    public int pow(int A, int B, int C) {
        int res=A%C;
        for (int i = 1; i < B; i++) {
            res = (res*(A%C))%C; 
        }
        return res;
    }

    
}