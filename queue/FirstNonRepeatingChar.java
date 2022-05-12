package queue;

import java.util.*;

/*
Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
B is formed such that we have to find the first non-repeating character each time a character
is inserted to the stream and append it at the end to B. If no non-repeating character is found,
append '#' at the end of B.
 */
public class FirstNonRepeatingChar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        FirstNonRepeatingChar ts = new FirstNonRepeatingChar();
        String res = ts.solve(input);
        System.out.println(res);
    }
    public String solve(String A) {
        Queue<Character> queue = new LinkedList<>();
        int flag[] = new int[27];
        for (int i = 0; i < 27; i++) {
            flag[i]=0;
        }
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            int index = (int)ch-(int)'a';
            flag[index]++;
            if(queue.isEmpty()){
                if(flag[index]<=1){
                    queue.add(ch);
                    res.append(ch);
                }else {
                    res.append("#");
                }

            }else{
                System.out.println(" stream "+ ch+ " contains "+queue.contains(ch));
                if(flag[index]>=1 && flag[index]<3)
                    queue.remove(ch);
                if(flag[index]<=1)
                    queue.add(ch);

                if(!queue.isEmpty())
                    res.append(queue.peek());
                else
                    res.append("#");
            }
            System.out.println(flag[index]);
            System.out.println(queue.toString());
            //System.out.println(res.toString());
        }

        return res.toString();
    }

}
//jpxvxivxkkthvpqhhhjuzhkegnzqriokhsgea