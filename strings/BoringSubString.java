package strings;
import java.util.Arrays;
import java.util.Scanner;
/*
A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.
*/
public class BoringSubString{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        
        
        BoringSubString pm = new BoringSubString();
        int res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public int solve(String A) {
        int n = A.length();
        StringBuilder even= new StringBuilder();
        StringBuilder odd= new StringBuilder();
        char a[] = A.toCharArray();
        
        for(int i=0; i<A.length() ; i++){
            if(a[i]%2==0){
                even.append(a[i]);
            }else{
                odd.append(a[i]);
            }
        }
        char tempEven[] = even.toString().toCharArray();
        char tempOdd[] = odd.toString().toCharArray();
        Arrays.sort(tempEven); System.out.println(tempEven);
        Arrays.sort(tempOdd); System.out.println(tempOdd);
        
        int ev=tempEven.length, od=tempOdd.length;
        
        if(Math.abs(tempEven[ev-1]-tempOdd[0])!=1 || Math.abs(tempOdd[od-1]-tempOdd[0])!=1 || Math.abs(tempEven[ev-1]-tempOdd[od-1])!=1 || Math.abs(tempEven[0]-tempOdd[0])!=1){
            return 1;
        }
            return 0;
    }
}