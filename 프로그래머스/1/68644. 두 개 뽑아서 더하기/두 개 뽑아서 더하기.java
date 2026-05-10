import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {

        HashSet<Integer> set = new HashSet<>();

        // 두 수 조합
        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                int sum = numbers[i] + numbers[j];

                set.add(sum);
            }
        }

        // Set -> 배열
        int[] answer = new int[set.size()];

        int index = 0;

        for (int num : set) {
            answer[index++] = num;
        }

        // 오름차순 정렬
        Arrays.sort(answer);

        return answer;
    }
}