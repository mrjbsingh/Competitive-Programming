import java.util.*;
public class FirstClass{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n\nHello player welcome to the game\n");
        System.out.println("I am jayendra, your host\n");
        System.out.println("       To play the game. \n       Please Enter your name -");
        String name = sc.next();
        System.out.println("\n\n       Hi "+ name);
        while(true){
            System.out.println("\n\nPress number for which you want table");
            int num = sc.nextInt();
            for(int i=num; i<=num; i++){
                System.out.print("\n Here's your table of- "+ i+"\n");
                System.out.print("\n----------------\n");
                for(int j=1; j<=10; j++){
                    System.out.print("|   "+i+"x"+j+" = "+i*j+"\n");
                }
                System.out.print("----------------\n");
                System.out.print("\n");
            
            }
        }
        
    }
}