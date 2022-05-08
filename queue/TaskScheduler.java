package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static my.utility.CodeTemplate.waitfun;

/*
A CPU has N tasks to be performed. It is to be noted that the tasks have to be completed
in a specific order to avoid deadlock. In every clock cycle, the CPU can either perform
a task or move it to the back of the queue. You are given the current state of the scheduler
queue in array A and the required order of the tasks in array B.

Determine the minimum number of clock cycles to complete all the tasks.
 */
public class TaskScheduler {
    public static void main(String[] args) {
        int size1, size2;
        ArrayList<Integer> A, B;
        A = new ArrayList<>();
        B = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        size1 = sc.nextInt();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }

        size2 = sc.nextInt();
        for (int i = 0; i < size2; i++) {
            B.add(sc.nextInt());
        }
        TaskScheduler ts = new TaskScheduler();
        int res = ts.solve(A, B);
        System.out.println(res);
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Queue<Integer> qu = new LinkedList<>();
        int count=0;
        for (int i = 0; i < A.size(); i++) {
            qu.add(A.get(i));
        }
        for (int i = 0; i < B.size(); i++) {

            while (!B.get(i).equals(qu.peek())){
                qu.add(qu.peek());
                qu.remove();
                count++;
            }
            count++;
            qu.remove();

        }
        return count;
    }
}
