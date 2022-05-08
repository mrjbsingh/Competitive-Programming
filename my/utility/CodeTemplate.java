package my.utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class CodeTemplate{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }

    }

    public void printArr(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public int customBSearch(int a[], int l, int h, int elem){
        int mid, ans, size=h;
        ans = 0;
        //System.out.println("elem "+ elem);
        while(l<=h){
            mid = (h+l)/2;
            //System.out.println("l "+l+" h "+h+" mid "+mid);
            if(a[mid] == elem){
                ans = mid;
                break;
            }
            else if(a[mid]<elem){
                //customBSearch(a, mid+1,h, elem);
                l= mid+1;
                ans = mid;
            }
            else if(a[mid]>elem){
                ans = a[mid]>elem? mid-1:mid;
                h= mid-1;
            }
            else{

            }
        }
        if(h<0) ans = a[0]>elem? -1:0;
        else if(l>size) ans = size;
        return ans+1;
    }
    public class Interval{
        int start;
        int end;
    
        public Interval(){
            start=0;
            end=0;
        }
        public Interval(int s, int e){
            start = s;
            end = e;
        }
    }
    /*
    How to use comparator on class while sorting on specified value

        Collections.sort(intervals, new IntervalComparator());

    */
    class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval i1, Interval i2){
            if(i1.start == i2.start){
                return 0;
            }
            else if(i1.start > i2.start)
                return 1;
            else
                return -1;
        }
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

    long factorial(long n)
    { 
        long m = 1000000007-1; //((a^(p-1))%p) = 1%p  fermat theorem concept
        // single line to find factorial
        return (n == 1 || n == 0) ? 1 : ((n%m) * (factorial(n - 1)%m))%m;
    }

    int gcd(int a, int b){
        if(a==0) return b;
        else{
            return gcd(b%a, a);
        }
    }

    // primeNum[i]==1 means i is prime num
    // 0 and 1 is not prime num so intialize by 0 or false

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

    public long modInverse(long a, long m)
    {
        long m0 = m;
        long y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1) {
            // q is quotient
            long q = a / m;
 
            long t = m;
 
            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x;
    }
    public static void waitfun(int sec){
        try {
            Thread.sleep(sec);  
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    String useStringBuilder(Stack st){
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}