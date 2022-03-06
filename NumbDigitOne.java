import java.util.Scanner;
/*
 */
public class NumbDigitOne{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
       
        int res;
        NumbDigitOne pm = new NumbDigitOne();
        res = pm.solve(size1);
        
        System.out.print(res);
        
    }
    public int solve(int A) {
        long sum=0; int num=A;
        //long m=
        int countOne[] = new int[100];
        countOne[0]=1;      //0-9
        countOne[1]=10;     //10-19
        calcNumDigitOne(A,0);
        
        return 0;
    }
    public int calcNumDigitOne(int num, int ithDigit){
        int sum=0;
        if(num==0)
            return 0;
        else if(num>0 && num<9){
            return 1;
        }else{
            while(num>0){
                int temp = num%10;      //for 199 it will give 9
                sum = sum + calcNumDigitOne(temp, ithDigit);
                num = num/10;           //for 199 it will give 19
                ithDigit++;
            }
            

        }
        return sum;
    }
    
}