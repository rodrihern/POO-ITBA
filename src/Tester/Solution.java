package Tester;

import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];
        int[] distFromZero = new int[n];
        List<List<Integer>> children = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            children.add(i, new ArrayList<>());
            children.get(i).add(i+1);
            distFromZero[i] = i;
        }


        for(int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            children.get(from).add(to);

            Queue<Integer> bfs = new LinkedList<>();
            bfs.add(from);
            while(!bfs.isEmpty()) {
                int current = bfs.poll();
                for(int child : children.get(current)) {
                    if(distFromZero[child] > distFromZero[current] + 1) {
                        distFromZero[child] = distFromZero[current] + 1;
                        if(child != n+1) {
                            bfs.add(child);
                        }
                    }
                }
            }
            res[i] = distFromZero[n-1];
        }

        return res;
    }

}