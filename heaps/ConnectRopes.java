package heaps;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

/*
You are given an array A of integers that represent the lengths of ropes.

You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.
*/
public class ConnectRopes {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
    
        ConnectRopes pm = new ConnectRopes();
        int res = pm.solve(A); 
        System.out.println(res);
        
    }
    public int solve(ArrayList<Integer> A) {
        for (int i = A.size()-1; i >=0; i--) {
            minHeapify(A, i);
        }
        System.out.println(A);
        System.out.println("Min heap ready\n\n");

        int cost=0;
        while (A.size()>1){
            int l1 = getMin(A);
            int l2 = getMin(A);
            System.out.println("l1 "+ l1 + " l2 "+ l2 + " cost "+ (l1+l2));

            cost += l1+ l2;
            A.add(l1+l2);
            minHeapify(A, 0);
        }
        return cost;
    }
    public int getMin(ArrayList<Integer> A){
        int min = A.get(0);
        A.set(0, A.get(A.size()-1));
        A.remove(A.size()-1);
        minHeapify(A,0);
        return min;
    }
    public void minHeapify(ArrayList<Integer> A, int index){
        System.out.println(index);
        int leftChild = 2*index+1;
        int rightChild = 2*index+2;
        System.out.println("left child" + leftChild);
        System.out.println("right child "+ rightChild);
        if((leftChild<A.size() && A.get(index)> A.get(leftChild)) ||  (rightChild<A.size() && A.get(index) > A.get(rightChild))){
            if(leftChild<A.size() && rightChild<A.size() && A.get(leftChild)< A.get(rightChild)){
                System.out.println("swapping with left");
                swap(A, index, leftChild);
                System.out.println(A);
                minHeapify(A, leftChild);
            } else if(rightChild<A.size()){
                System.out.println("swapping with right");
                swap(A, index, rightChild);
                System.out.println(A);
                minHeapify(A, rightChild);
            }else if(leftChild<A.size() && A.get(leftChild)<A.get(index)) {
                System.out.println("swapping with left only child");
                swap(A, index, leftChild);
                System.out.println(A);
                minHeapify(A, rightChild);
            }
        }
    }
    public void swap(ArrayList<Integer> A, int index, int index2){
        int temp = A.get(index);
        A.set(index, A.get(index2));
        A.set(index2, temp);
    }
    
}
//4 5 17 100 11