import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();

        int time = 0;
        int currentWeight = 0;

        // 처음 다리 상태 0으로 채우기
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int index = 0;

        while (index < truck_weights.length) {

            // 시간 흐름
            time++;

            // 맨 앞 트럭 빠짐
            currentWeight -= bridge.poll();

            // 새 트럭 올라갈 수 있는지
            if (currentWeight + truck_weights[index] <= weight) {

                bridge.offer(truck_weights[index]);
                currentWeight += truck_weights[index];

                index++;

            } else {
                // 못 올라가면 빈 공간
                bridge.offer(0);
            }
        }

        // 마지막 트럭 지나가는 시간 추가
        return time + bridge_length;
    }
}