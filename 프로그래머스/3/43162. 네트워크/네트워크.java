class Solution {

    boolean[] visited;
    public int solution(int n, int[][] computers) {

        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public void dfs(int now, int[][] computers) {

        visited[now] = true;
        for (int next = 0; next < computers.length; next++) {
            if (computers[now][next] == 1 && !visited[next]) {

                dfs(next, computers);
            }
        }
    }
}