package strings;
import java.util.Scanner;
/*
You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:
A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
*/
public class ReverseStrWord{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        
        
        ReverseStrWord pm = new ReverseStrWord();
        String res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public String solve(String A) {
        int n= A.length();
        char a[] = A.toCharArray();
        reverseString(a, 0,n);
        int start=0;
        for(int i=0; i<n; i++){
            if(a[i]==' '){
                
                reverseString(a, start, i);
                start=i+1;
                //break;
            }
        }
        reverseString(a, start, n);
        
        return String.valueOf(a).trim().replaceAll("\\s+", " ");
    }
    void reverseString(char a[], int start, int end){
        char temp; 
        while(start < end){
            temp = a[start];
            a[start] = a[end-1];
            a[end-1] = temp;
            start++;
            end--;
        }
    }
}