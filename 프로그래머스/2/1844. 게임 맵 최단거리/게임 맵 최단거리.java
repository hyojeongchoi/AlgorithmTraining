import java.util.*;

class Solution {

    static class Node {
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            // 도착
            if (now.x == n - 1 && now.y == m - 1) {
                return now.dist;
            }

            for (int i = 0; i < 4; i++) {

                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 벽이면 못감
                if (maps[nx][ny] == 0) {
                    continue;
                }

                // 이미 방문했으면 패스
                if (visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, now.dist + 1));
            }
        }

        return -1;
    }
}