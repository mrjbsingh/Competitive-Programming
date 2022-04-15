package hashmap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.

Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".

If it is possible, return 1, else return -1.
*/
public class ReplicatingSubstring{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String B = sc.nextLine();
        
        ReplicatingSubstring pm = new ReplicatingSubstring();
        int res = pm.solve(A, B);
        
        System.out.print(res);
        
        
        
    }
    public int solve(int A, String B) {
        int n= B.length();
        Map <String, Integer> hmap = new HashMap<>();
        int tempVal;
        if( (n%A) != 0)
            return -1;

        for(int i=0; i<n; i++){
            String key = String.valueOf(B.charAt(i));
            if(hmap.containsKey(key)){
                tempVal = hmap.get(key);
                hmap.put(key, ++tempVal);
            }
            else{
                
                hmap.put(key, 1);
            }
        }
        for(Map.Entry<String, Integer> e: hmap.entrySet()){
            if(e.getValue()%A!=0){
               
                return -1;
            }
        }
        return 1;
    }
}