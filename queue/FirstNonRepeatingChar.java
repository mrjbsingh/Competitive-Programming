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
        Deque<Character> deque = new LinkedList<>();
        char stream[] = A.toCharArray();
        int flag[] = new int[26];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            int index = (int)stream[i]-(int)'a';
            flag[index]++;
            if(deque.isEmpty()){
                if(flag[index]<=1)
                deque.add(stream[i]);
                    res.append(stream[i]);
            }else{
                System.out.println(" stream "+ stream[i]+ " contains "+deque.contains(stream[i]));
                if(deque.contains(stream[i]))
                    deque.removeFirstOccurrence(stream[i]);
                else {
                    if(flag[index]<=1)
                    deque.add(stream[i]);
                }
                if(!deque.isEmpty())
                    res.append(deque.getFirst());
                else
                    res.append("#");
            }
        }

        return res.toString();
    }

}
//jpxvxivxkkthvpqhhhjuzhkegnzqriokhsgea