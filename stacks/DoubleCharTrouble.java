package stacks;
import java.util.Scanner;
import java.util.Stack;
/*
You are given a string A.

An operation on the string is defined as follows:

Remove the first occurrence of the same consecutive characters. 
eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".

Therefore the string after this operation will be "acd".

Keep performing this operation on the string until there are no more 
occurrences of the same consecutive characters and return the final string.
*/
public class DoubleCharTrouble{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        String A = sc.nextLine();
        
        
        DoubleCharTrouble pm = new DoubleCharTrouble();
        String res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public String solve(String A) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<A.length(); i++){
            if(!st.empty() && st.peek().equals(A.charAt(i))){
                st.pop();
            }else{
                st.push(A.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}