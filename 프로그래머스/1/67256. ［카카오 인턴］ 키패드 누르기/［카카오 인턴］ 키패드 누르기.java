class Solution {
    public String solution(int[] numbers, String hand) {

        String answer = "";

        // 좌표 (0은 따로 처리)
        int[][] pos = {
            {3,1}, // 0
            {0,0},{0,1},{0,2},
            {1,0},{1,1},{1,2},
            {2,0},{2,1},{2,2}
        };

        int lx = 3, ly = 0; // * 위치
        int rx = 3, ry = 2; // # 위치

        for (int num : numbers) {

            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                lx = pos[num][0];
                ly = pos[num][1];

            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                rx = pos[num][0];
                ry = pos[num][1];

            } else {
                int nx = pos[num][0];
                int ny = pos[num][1];

                int leftDist = Math.abs(lx - nx) + Math.abs(ly - ny);
                int rightDist = Math.abs(rx - nx) + Math.abs(ry - ny);

                if (leftDist < rightDist) {
                    answer += "L";
                    lx = nx;
                    ly = ny;
                } else if (rightDist < leftDist) {
                    answer += "R";
                    rx = nx;
                    ry = ny;
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        rx = nx;
                        ry = ny;
                    } else {
                        answer += "L";
                        lx = nx;
                        ly = ny;
                    }
                }
            }
        }

        return answer;
    }
}