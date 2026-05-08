import java.util.*;

class Solution {
    public int solution(int[] topping) {

        int answer = 0;

        // 오른쪽 토핑 개수 관리
        HashMap<Integer, Integer> right = new HashMap<>();

        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        // 왼쪽은 종류만 관리
        HashSet<Integer> left = new HashSet<>();

        for (int t : topping) {

            // 왼쪽 추가
            left.add(t);

            // 오른쪽 제거
            right.put(t, right.get(t) - 1);

            // 개수 0이면 삭제
            if (right.get(t) == 0) {
                right.remove(t);
            }

            // 종류 개수 같으면
            if (left.size() == right.size()) {
                answer++;
            }
        }

        return answer;
    }
}