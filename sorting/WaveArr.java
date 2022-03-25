package sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
Given an array of integers A, sort the array into a wave-like array and return it.
In other words, arrange the elements into a sequence such that

a1 >= a2 <= a3 >= a4 <= a5..... 
*/
public class WaveArr{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
    
        WaveArr pm = new WaveArr();
        ArrayList<Integer> res = pm.wave(A); 
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        
        
    }
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<A.size(); ){
            if(i+1<A.size())
                res.add(A.get(i+1));
            res.add(A.get(i));
            i+=2;       
        }
        return res;
    }
}