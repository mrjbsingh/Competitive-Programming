package mockinterviewqst;

import java.util.HashMap;
import java.util.Map;

public class MultiplyTwoString {
    public static void main(String[] args) {
        String s1 = "28";
        String s2 = "22";
        MultiplyTwoString obj = new MultiplyTwoString();
        String res = obj.multiplyStrings(s1, s2);
        System.out.println(res);
    }
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        int n1 = s1.length();
        int n2 = s2.length();

        StringBuilder str = new StringBuilder();
        StringBuilder sumStr = new StringBuilder();
        int carry;
        for(int j=n1-1; j>=0; j--){
            carry=0;
            str = new StringBuilder();
            int numZero = n1-1 -j;
            while(numZero>=0){

                str.append('0');
                numZero--;
            }
            for(int i =n2-1; i>=0; i--){
                int val1 = s1.charAt(i)- '0'; //3

                int val2 = s2.charAt(j)- '0';  //2
                int res = val1*val2 + carry;           //9*9 = 8 1 //8*2 +8 = 24
                str.append(String.valueOf(res%10));
                carry = res/10;            //8

            }
            str.append(String.valueOf(carry)); //142
            sumStr = str.length()>sumStr.length()? addString(str, sumStr) : addString(sumStr, str) ;   // 580, 241 = 821

        }
        return sumStr.reverse().toString();

    }
    // 1234 --> 4321
    // 0089 --> 9800
    // 1323      3231
    public StringBuilder addString(StringBuilder str1, StringBuilder str2){
        StringBuilder addStr = new StringBuilder();
        int carry=0;
        for(int i=0; i<str1.length(); i++){
            int val1 = str1.charAt(i)- '0'; //3

            int val2 = i<str2.length()? (str2.charAt(i)- '0'): 0;
            int add = val1+val2+ carry;
            addStr.append(String.valueOf(add%10));
            carry = add/10;
        }
        addStr.append(String.valueOf(carry)); //reverse order
        return addStr;
    }
}
