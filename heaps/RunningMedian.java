package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

Find and return the array C.
*/
public class RunningMedian {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
    
        RunningMedian pm = new RunningMedian();
        ArrayList<Integer> res = pm.solve(A);
        System.out.println(res);
        
    }
    public ArrayList<Integer> solve(ArrayList<Integer> stream) {
        PriorityQueue<Integer> minHeapRightSide = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeapLeftSide = new PriorityQueue<>((a, b)-> Integer.compare(b , a));
        ArrayList<Integer> res = new ArrayList<>();

        maxHeapLeftSide.offer(stream.get(0));
        res.add(maxHeapLeftSide.peek());

        for (int i = 1; i < stream.size(); i++) {
            if(maxHeapLeftSide.peek()< stream.get(i)){
                minHeapRightSide.offer(stream.get(i));
            }else {
                maxHeapLeftSide.offer(stream.get(i));
            }
            //balance as per size of both heaps to always get median from left side MaxHeap
            if(maxHeapLeftSide.size() - minHeapRightSide.size()>1){
                minHeapRightSide.offer(maxHeapLeftSide.poll());
            }else if(minHeapRightSide.size()- maxHeapLeftSide.size()>1){
                maxHeapLeftSide.offer(minHeapRightSide.poll());
            }
            if(minHeapRightSide.size()>maxHeapLeftSide.size())
                res.add(minHeapRightSide.peek());
            else
                res.add(maxHeapLeftSide.peek());
        }
        return res;
    }
}
//12 32 91 86 8 4 100 98 15 79 32 4 99
//4 8 32 86 91

//32 32 86 32 32 32 86 32 79 32 32 32
