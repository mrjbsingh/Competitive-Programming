package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class CheckBipartite {
    static int maxn = 100009;
    static ArrayList <ArrayList< Integer >> graph;
    public static void graphC() {
        graph = new ArrayList < ArrayList < Integer > > (maxn);
        for (int i = 0; i < maxn; i++) {
            graph.add(new ArrayList < Integer > ());
        }
    }
    public int solve(int A, int[][] B) {
        graphC();
        for (int[] edge: B) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        if (isBipartite(A) == true)
            return 1;
        return 0;
    }
    public static boolean isBipartite(int n) {
        if (n == 0)
            return true;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        Queue< Integer > q = new ArrayDeque< >();
        for (int i = 0; i < n; ++i) {
            if (color[i] != -1)
                continue;
            color[i] = 1;
            q.offer(i);
            while (q.size() > 0) {
                int x = q.poll();
                for (int it: graph.get(x)) {
                    if (color[it] == -1) {
                        color[it] = color[x] ^ 1;
                        q.offer(it);
                    } else if (color[it] == color[x])
                        return false;
                }
            }
        }
        return true;
    }
}
