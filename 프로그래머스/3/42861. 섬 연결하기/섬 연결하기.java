import java.util.*;

class Solution {

    int[] parent;

    public int solution(int n, int[][] costs) {

        int answer = 0;

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for (int[] cost : costs) {

            int a = cost[0];
            int b = cost[1];
            int value = cost[2];

            if (find(a) != find(b)) {

                union(a, b);

                answer += value;
            }
        }

        return answer;
    }

    public int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pb] = pa;
        }
    }
}