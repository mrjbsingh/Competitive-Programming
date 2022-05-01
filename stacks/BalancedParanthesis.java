package stacks;
import java.util.Scanner;
import java.util.Stack;
/*
Given an expression string A, examine whether the pairs and 
the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
Input 1:
 A = {([])}
Input 2:
 A = (){

Example Output
Output 1:
 1 
Output 2:
 0 
*/
public class BalancedParanthesis{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        String A = sc.nextLine();
        
        
        BalancedParanthesis pm = new BalancedParanthesis();
        int res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public int solve(String A) {
        Stack<String> st = new Stack<>();
        int n = A.length();
        char a[] = A.toCharArray();
        for(int i=0; i<n; i++){
            if(a[i]=='{' || a[i]=='(' || a[i]=='['){
                st.push(String.valueOf(a[i]));
            }else if(!st.empty()){
               
                if(a[i]=='}' && st.peek().equals("{")){
                    st.pop();
                }
                else if(a[i]==')' && st.peek().equals("(")){
                    st.pop();
                }
                else if(a[i]==']' && st.peek().equals("[")){
                    st.pop();
                }
                else{
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
        if(st.empty())
        return 1;
        else
        return 0;
    }
}