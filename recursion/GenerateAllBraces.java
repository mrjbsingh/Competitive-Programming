package recursion;
import java.util.ArrayList;
import java.util.Scanner;

/*
Input 1:

A = 3
Input 2:

A = 1

Example Output
Output 1:

[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
Output 2:

[ "()" ]
 */
public class GenerateAllBraces{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        
        GenerateAllBraces pm = new GenerateAllBraces();
        ArrayList<String> res = pm.generateParenthesis(A);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> res = new ArrayList<>();
        solve(A, 0, A*2, "", res);
        return res;
    }
    void solve(int count, int diff, int len, String combination, ArrayList<String> res){
        if(len == 0){
            res.add(combination);
            return ;
        }
        if(count>0){
            solve(count-1, diff+1, len-1, combination+"(", res);
        }
        if(diff>0){
            solve(count, diff-1, len-1, combination+")", res);
        }
        
    }

   
}