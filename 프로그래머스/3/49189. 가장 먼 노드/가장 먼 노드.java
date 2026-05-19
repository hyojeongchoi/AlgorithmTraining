import java.util.*;

class Solution {

    public int solution(int n, int[][] edge) {

        // 그래프
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 연결
        for (int[] e : edge) {

            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        // 거리 저장
        int[] dist = new int[n + 1];

        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);

        dist[1] = 0;

        // BFS
        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int next : graph[now]) {

                // 아직 방문 안 했으면
                if (dist[next] == -1) {

                    dist[next] = dist[now] + 1;

                    queue.offer(next);
                }
            }
        }

        // 최대 거리 찾기
        int max = 0;

        for (int d : dist) {
            max = Math.max(max, d);
        }

        // 최대 거리 개수 세기
        int answer = 0;

        for (int d : dist) {

            if (d == max) {
                answer++;
            }
        }

        return answer;
    }
}