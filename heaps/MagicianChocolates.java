package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.

Find the maximum number of chocolates that the kid can eat in A units of time.

NOTE:

floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7
*/
public class MagicianChocolates {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        int size1 = sc.nextInt();
        ArrayList <Integer> bags = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            bags.add(sc.nextInt());
        }
    
        MagicianChocolates pm = new MagicianChocolates();
        int res = pm.nchoc(time, bags);
        System.out.println(res);
        
    }
    public int nchoc(int time, ArrayList<Integer> bags) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)-> (y-x));
        int M = 1000000007;
        for (int i = 0; i < bags.size(); i++) {
            pq.offer(bags.get(i));
        }
        long numbChoc = 0;
        while (time-- >0 && !pq.isEmpty()){
            int temp = pq.poll();
            numbChoc =  (numbChoc + (long)temp)%M;
            pq.offer(temp/2);
        }
        return (int)numbChoc%M;
    }
}
//284628164
