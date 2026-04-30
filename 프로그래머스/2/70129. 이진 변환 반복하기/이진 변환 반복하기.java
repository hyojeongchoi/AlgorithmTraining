class Solution {
    public int[] solution(String s) {

        int convertCount = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {

            int before = s.length();
            s = s.replaceAll("0", "");
            zeroCount += (before - s.length());
            s = Integer.toBinaryString(s.length());
            convertCount++;
        }

        return new int[]{convertCount, zeroCount};
    }
}