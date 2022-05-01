package stacks;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each character may be an integer or an operator.
*/
public class EvaluateExpression{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        int size1 = sc.nextInt();
        ArrayList<String> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.next());
        }
        
        
        EvaluateExpression pm = new EvaluateExpression();
        int res = pm.evalRPN(A);
        
        System.out.print(res);
        
    }
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> st = new Stack<>();
       
        for(int i=0 ; i< A.size(); i++){
            if(A.get(i).equals("+") && st.size()>=2){
                st.push(st.pop() + st.pop());
            }
            else if(A.get(i).equals("-") && st.size()>=2){
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(n2 - n1 ); 
            }
            else if(A.get(i).equals("*") && st.size()>=2){
                st.push(st.pop() * st.pop()); 
            }
            else if(A.get(i).equals("/") && st.size()>=2){
                int n1 = st.pop();
                int n2 = st.pop();
                st.push(n2 / n1 ); 
            }
            else{
                st.push(Integer.parseInt(A.get(i)));
            }
        }
        return st.pop();
    }
}