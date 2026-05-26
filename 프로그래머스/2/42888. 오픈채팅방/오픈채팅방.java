import java.util.*;

class Solution {

    public String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>();

        List<String[]> log = new ArrayList<>();

        for (String r : record) {

            String[] arr = r.split(" ");
            String type = arr[0];
            String uid = arr[1];

            if (!type.equals("Leave")) {

                String nick = arr[2];
                map.put(uid, nick);
            }

            if (!type.equals("Change")) {
                log.add(new String[]{type, uid});
            }
        }

        String[] answer = new String[log.size()];

        for (int i = 0; i < log.size(); i++) {

            String type = log.get(i)[0];
            String uid = log.get(i)[1];
            String nick = map.get(uid);

            if (type.equals("Enter")) {
                answer[i] = nick + "님이 들어왔습니다.";
            } else {
                answer[i] = nick + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}