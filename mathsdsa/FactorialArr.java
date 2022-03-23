package mathsdsa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
Given an integer A which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.

A person moves to and fro changing the states of the doors as follows: the person opens a door that is already closed and closes a door that is already opened.

In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
In the third go, he/she alters the states of doors numbered 3, 6, 9 …
This continues till the A'th go in which you alter the state of the door numbered A.

Find and return the number of open doors at the end of the procedure.
https://www.scaler.com/academy/mentee-dashboard/class/19125/assignment/problems/4106/
*/
public class FactorialArr{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int res;
        FactorialArr pm = new FactorialArr();
        res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A);
        int highestNum = 1000000+7;  //some element as buffer;
        int primeNum[] = sieveGetAllPrime(highestNum);      // getting prime of largest numb it will also have prime factor of rest of small numb
        long ans =0; long m = 1000000007;
        for(int i=0; i<n;){
            
            int num = A.get(i); //System.out.println("num "+ num);
            int nextPrime=num+1;
            for(int j=nextPrime; j<=highestNum; j++){
                if(primeNum[j]==1){
                    nextPrime=j;
                    break;
                }
            }
            //System.out.println(" nextPrime "+nextPrime);
            int count=0;
            while(i<n && A.get(i)<nextPrime){
                count++;
                i++;
            }
            if(num==1) count=0; //edge case as 1 as no primefactor
            //System.out.println("count "+count);
            ans = (ans + fastPower(2, count, m)-1)%m;
            //System.out.println("ans "+ ans);
            
        }
        return (int) ans;
    }
    int [] sieveGetAllPrime(int A){
        int primeNum[] = new int[A+1];
        for(int i=2; i<A; i++){
            primeNum[i]=1;
        }
        for(int i=2; i*i<=A; i++){
            if(primeNum[i]==0)
                continue;
            else{
                for(int j=i*i; j<=A; j+=i){
                    primeNum[j]=0;
                }
            }
        }
        return primeNum;
    }

    long fastPower(long a, long b, long m){
        //System.out.println("a b "+ a+" "+b);
        a=a%m;
        if(b==0)
        return 1;
        if(b%2==1){
            return ((a%m)*(fastPower((a*a)%m,(b-1)/2,m)%m))%m;
        }
        else{
            return fastPower((a*a)%m,b/2,m)%m;
        }
    }
}