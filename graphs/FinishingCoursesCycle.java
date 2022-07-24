package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FinishingCoursesCycle {
    boolean visit[];
    boolean path[];
    Map<Integer, ArrayList<Integer>> adjacentList = new HashMap<>();
    public int solve(int numOfNode, int[] B, int[] C){
        for (int i = 0; i < B.length; i++) {
            ArrayList<Integer> edgeList;
            if(adjacentList.containsKey(B[i])){
                edgeList = adjacentList.get(B[i]);
            }
            else {
                edgeList = new ArrayList<Integer>();
            }
            edgeList.add(C[i]);
            adjacentList.put(B[i], edgeList);
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
