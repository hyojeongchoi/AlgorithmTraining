class Solution {

    int count = 0;

    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return count;
    }

    public void dfs(int[] numbers, int target, int current, int idx) {

        if (idx == numbers.length) {

            if (current == target) {
                count++;
            }

            return;
        }

        dfs(numbers, target,
                current + numbers[idx],
                idx + 1);

        dfs(numbers, target,
                current - numbers[idx],
                idx + 1);
    }
}