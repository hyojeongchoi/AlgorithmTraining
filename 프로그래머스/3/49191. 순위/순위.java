class Solution {

    public int solution(int n, int[][] results) {

        boolean[][] win = new boolean[n + 1][n + 1];

        // 승패 저장
        for (int[] result : results) {

            int winner = result[0];
            int loser = result[1];

            win[winner][loser] = true;
        }

        // 플로이드 워셜
        for (int mid = 1; mid <= n; mid++) {

            for (int i = 1; i <= n; i++) {

                for (int j = 1; j <= n; j++) {

                    // i > mid && mid > j
                    if (win[i][mid] && win[mid][j]) {

                        win[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;

        // 순위 확정 가능한 선수 찾기
        for (int i = 1; i <= n; i++) {

            int count = 0;

            for (int j = 1; j <= n; j++) {

                // 자기 자신 제외
                if (i == j) {
                    continue;
                }

                // 승패 관계 알 수 있으면
                if (win[i][j] || win[j][i]) {
                    count++;
                }
            }

            // 나 제외 모든 선수와 관계 확정
            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}