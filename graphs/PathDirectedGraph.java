package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
Given an directed graph having A nodes labelled from 1 to A containing M edges
given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.
 */
public class PathDirectedGraph {
    boolean visit[];
    Map<Integer, ArrayList<Integer>> adjacentList = new HashMap<>();
    public int solve(int numOfNode, int[][] edges) {

        for (int i = 0; i < edges.length; i++) {
            ArrayList<Integer> edgeList;
            if(adjacentList.containsKey(edges[i][0])){
                edgeList = adjacentList.get(edges[i][0]);
            }
            else {
                edgeList = new ArrayList<Integer>();
            }
            edgeList.add(edges[i][1]);
            adjacentList.put(edges[i][0], edgeList);
        }
        visit = new boolean[numOfNode+1];
        Arrays.fill(visit, false);
        dfs(1);
        return visit[numOfNode]? 1 : 0;
    }
    void dfs(int nodeIndex){
        visit[nodeIndex] = true;
        if(adjacentList.containsKey(nodeIndex)){
            for ( Integer nextNode: adjacentList.get(nodeIndex)) {
                if(!visit[nextNode]){
                    dfs(nextNode);
                }
            }
        }

    }
}
