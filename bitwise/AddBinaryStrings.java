package bitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 */
public class AddBinaryStrings{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
       
        AddBinaryStrings pm = new AddBinaryStrings();
        String res = pm.addBinary(A, B);
        
        System.out.print(res);
        
    }
    public String addBinary(String A, String B) {
        int alen=A.length();
        int blen=B.length();
        int len=0;
        String temp="", res="";
        //make them equal length string +1 to manage carryforward
       // System.out.println("alen blen"+ alen +" "+ blen);
        if(alen<blen){
            for(int i=0;i<blen-alen+1; i++)    //one extra zero to manage carryforward
                temp+='0';
            A= temp+A;
            len = blen+1;
            B='0'+B;
        }else if(alen>blen) {
            temp="";
            for(int i=0;i<alen-blen+1; i++)    //one extra zero to manage carryforward
                temp+='0';
            //System.out.println("temp "+ temp);
            B= temp+B;
            len = alen+1;
            A='0'+A;
        }
        else if(alen==blen){
            A='0'+A;
            B='0'+B;
            len = alen+1;
        }
        // System.out.println("A "+A);
        // System.out.println("B "+B);
        // System.out.println("len "+len);
        int a,b,carry=0, total;
        for(int i=len-1; i>=0;i--){
            a=getIntVal(A.charAt(i));
            b=getIntVal(B.charAt(i));
            total=a+b+carry;
            if(total==0)
            {
                res='0'+res;
                carry=0;
            }
            else if(total==1)
            {
                res='1'+res;
                carry=0;
            }else if(total==2)
            {
                res='0'+res;
                carry=1;
            }else if(total==3)
            {
                res='1'+res;
                carry=1;
            }
        }
        if(res.charAt(0)=='0')
         return res.substring(1);
        else
            return res;
    }
    public int getIntVal(char ch){
        if(ch=='0')
        return 0;
        else
        return 1;
    }
    
}