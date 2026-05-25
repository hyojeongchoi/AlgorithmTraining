import java.util.*;

class Solution {

    public int[] solution(String[] gems) {

        int[] answer = new int[2];

        // 전체 보석 종류 개수
        Set<String> set = new HashSet<>();

        for (String gem : gems) {
            set.add(gem);
        }

        int kind = set.size();

        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;

        while (right < gems.length) {

            // 보석 추가
            map.put(gems[right],
                    map.getOrDefault(gems[right], 0) + 1);

            right++;

            // 모든 종류 포함하면
            while (map.size() == kind) {

                // 최소 구간 갱신
                if (right - left < minLength) {

                    minLength = right - left;

                    answer[0] = left + 1;
                    answer[1] = right;
                }

                // 왼쪽 보석 제거
                map.put(gems[left], map.get(gems[left]) - 1);

                // 개수 0이면 제거
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }

                left++;
            }
        }

        return answer;
    }
}