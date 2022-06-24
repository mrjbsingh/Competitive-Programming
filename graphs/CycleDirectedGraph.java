package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an directed graph having A nodes labelled from 1 to A containing M edges
given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

Return 1 if path exists else return 0.
 */
public class CycleDirectedGraph {
    boolean visit[];
    boolean path[];
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
        visit = new boolean[numOfNode + 1];
        path = new boolean[numOfNode + 1];
        Arrays.fill( visit, false);
        Arrays.fill( path, false);
        boolean isCyclePresent = false;

        for (int i = 1; i <=numOfNode; i++) {
            if(!visit[i]){
                if(dfs(i)){
                    isCyclePresent = true;
                }
            }
        }

        return isCyclePresent? 1 : 0;
    }
    boolean dfs(int nodeIndex){
        visit[nodeIndex] = true;
        path[nodeIndex] = true;     //set nodeIndex in current Path
        if(adjacentList.containsKey(nodeIndex)){
            for ( Integer nextNode: adjacentList.get(nodeIndex)) {
                if(path[nextNode]){         //if node visited again means cycle found
                    return true;
                }
                if(!visit[nextNode]){
                    if(dfs(nextNode)){      //if any of internal cycle found it will just pass true to above
                        return true;
                    }
                }
            }
        }
        path[nodeIndex] = false;     //unset the path
        return false;               //it will reach here if cycle is not found
    }
}
