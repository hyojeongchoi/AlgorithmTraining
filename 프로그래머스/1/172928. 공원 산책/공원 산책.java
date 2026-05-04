class Solution {
    public int[] solution(String[] park, String[] routes) {

        int x = 0, y = 0;

        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                x = i;
                y = park[i].indexOf("S");
                break;
            }
        }

        // 명령 실행
        for (String route : routes) {

            String[] r = route.split(" ");
            String dir = r[0];
            int dist = Integer.parseInt(r[1]);

            int nx = x;
            int ny = y;

            boolean canMove = true;

            for (int i = 0; i < dist; i++) {

                if (dir.equals("E")) ny++;
                else if (dir.equals("W")) ny--;
                else if (dir.equals("S")) nx++;
                else if (dir.equals("N")) nx--;

                if (nx < 0 || ny < 0 || nx >= park.length || ny >= park[0].length()) {
                    canMove = false;
                    break;
                }

                if (park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }

            // 가능하면 이동
            if (canMove) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }
}