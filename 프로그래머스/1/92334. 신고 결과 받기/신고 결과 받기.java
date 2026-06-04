import java.util.*;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        Map<String, Integer> reportCount = new HashMap<>();

        for (String id : id_list) {
            reportCount.put(id, 0);
        }

        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        Map<String, Set<String>> reportMap = new HashMap<>();

        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }

        for (String r : reportSet) {

            String[] arr = r.split(" ");

            String from = arr[0];
            String to = arr[1];

            reportMap.get(from).add(to);

            reportCount.put(to, reportCount.get(to) + 1);
        }

        for (int i = 0; i < id_list.length; i++) {

            String user = id_list[i];

            for (String target : reportMap.get(user)) {

                if (reportCount.get(target) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}