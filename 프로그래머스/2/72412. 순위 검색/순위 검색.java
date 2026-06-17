import java.util.*;

class Solution {

    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        for (String s : info) {
            String[] arr = s.split(" ");
            makeKey(arr, 0, "", Integer.parseInt(arr[4]));
        }

        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {

            String q = query[i]
                    .replaceAll(" and ", "")
                    .replaceAll("-", "");

            String[] arr = q.split(" ");

            String key = arr[0];
            int score = Integer.parseInt(arr[1]);

            List<Integer> list =
                    map.getOrDefault(key, new ArrayList<>());

            int idx = lowerBound(list, score);

            answer[i] = list.size() - idx;
        }

        return answer;
    }

    private void makeKey(String[] arr,
                         int depth,
                         String key,
                         int score) {

        if (depth == 4) {
            map.computeIfAbsent(key,
                    k -> new ArrayList<>()).add(score);
            return;
        }

        makeKey(arr, depth + 1,
                key + arr[depth], score);

        makeKey(arr, depth + 1,
                key, score);
    }

    private int lowerBound(List<Integer> list,
                           int target) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid = (left + right) / 2;

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}