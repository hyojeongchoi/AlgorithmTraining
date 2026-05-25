import java.util.*;

class Solution {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {

        int answer = 0;

        int x = 0;
        int y = 0;

        // 방문한 점
        Set<String> visitedNode = new HashSet<>();

        // 방문한 간선
        Set<String> visitedEdge = new HashSet<>();

        visitedNode.add(x + "," + y);

        for (int arrow : arrows) {

            // 교차점 처리 때문에 2번 이동
            for (int i = 0; i < 2; i++) {

                int nx = x + dx[arrow];
                int ny = y + dy[arrow];

                String node = nx + "," + ny;

                String edge1 = x + "," + y + ":" + nx + "," + ny;
                String edge2 = nx + "," + ny + ":" + x + "," + y;

                // 이미 방문한 점인데
                // 처음 지나가는 길이면 방 생성
                if (visitedNode.contains(node)
                        && !visitedEdge.contains(edge1)) {

                    answer++;
                }

                visitedNode.add(node);

                visitedEdge.add(edge1);
                visitedEdge.add(edge2);

                x = nx;
                y = ny;
            }
        }

        return answer;
    }
}