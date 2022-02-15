import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) {
        int num[] = new int[10];  // declaration type 1 with intial val 0

        int num2[] = {1,2,3,4,5};

        //int num3[] = new int[10];
        // for (int i = 0; i < num2.length; i++) {
        //     System.out.println(num2[i]);
        // }
        int arr[][] = {
            {1,2,3,4},
            {1,2,3,4},
            {1,2,3,4}
        };
        int arr2[][] = new int[3][5];

        //Dynamic memory allocation to array;
        
        Scanner sc = new Scanner(System.in);
       
        /*int size = sc.nextInt();
        int arr3[] = new int[size];
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }*/

        //Dynamic memory 2D array
        System.out.println("please entter numb of row in 2-d array");
        int size1 = sc.nextInt();
        
        int arr4[][] = new int[size1][];
        for (int i = 0; i < arr4.length; i++) {
            
            System.out.println("Enter size of "+i+" row");
            int size2 = sc.nextInt();
            arr4[i] = new int[size2];

        }
        System.out.println("Your Array");
        // for (int i = 0; i < arr4.length; i++) {
            
        //     for (int j = 0; j < arr4[i].length; j++) {
        //         System.out.print(arr4[i][j]);
        //     }
        //     System.out.println();

        // }

        for(int k[]:arr4){
            for(int l:k){
                System.out.print(" "+l);
            }
            System.out.println();
        }
        
    }
}
