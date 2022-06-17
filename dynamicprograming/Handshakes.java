package dynamicprograming;
/*
We have N persons sitting on a round table. Any person can do a handshake with any other person.

     1
2         3
     4

Handshake with 2-3 and 1-4 will cause cross.
In how many ways these N people can make handshakes so that no two handshakes cross each other. N would be even.

Input:
N = 2
Output:
1
Explanation:
{1,2} handshake is
possible.

Input:
N = 4
Output:
2
Explanation:
{{1, 2}, {3, 4}} are the
two handshakes possible.
{{1, 3}, {2, 4}} is another
set of handshakes possible.
 */
public class Handshakes {
    int count(int n){
        // code here
        int total =0,i, leftTotal=0,rightTotal=0;
        if(n==0 || n==2)
            return 1;

        if(n==4)
            return 2;
        for (i=1;i<n;){
            leftTotal = count(i-1);
            rightTotal = count (n-(i+1));
            total += leftTotal*rightTotal;
            i+=2;
        }
        return total;
    }
}
