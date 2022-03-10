package bitwise;

import java.util.ArrayList;
import java.util.Scanner;
/*
Given an integer array A of N integers, 
find the pair of integers in the array which have minimum XOR value. 
Report the minimum XOR value.
Input 1:

 A = [0, 2, 5, 7]
 Output : 2
*/
public class MinXOR{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        
        MinXOR pm = new MinXOR();
        int res = pm.findMinXor(A);
       
            System.out.print(res);
        
       
        
    }
    public int findMinXor(ArrayList<Integer> A) {      
        
        return findRecursive(A,31);
        
    }
    public int findRecursive(ArrayList<Integer> A, int bit){
        ArrayList<Integer> allZeros = new ArrayList<>();
        ArrayList<Integer> allOnes = new ArrayList<>();   
        if(bit<0 && A.size()>=2){
            return A.get(0)^A.get(1);
        }
        if(A.size()<=1)
            return Integer.MAX_VALUE;
        else if(A.size()==2)
            return A.get(0)^A.get(1);
        else{
            for(int i=0; i<A.size(); i++){
                if((A.get(i)&(1<<bit))>0){
                    allOnes.add(A.get(i));
                }else{
                    allZeros.add(A.get(i));
                }
            }
            System.out.print("\nones arr - ");
            for(int i=0; i<allOnes.size(); i++){
                
                System.out.print(allOnes.get(i)+" ");  
            }
            System.out.print("\nzero arr - ");
            for(int i=0; i<allZeros.size(); i++){
                
                System.out.print(allZeros.get(i)+" ");  
            }
            return Math.min(findRecursive(allOnes,bit-1), findRecursive(allZeros,bit-1));
        }
        
    }
    
}