class Solution {
    public int solution(int n) {
        int ones = Integer.bitCount(n);
        int num = n + 1;
        int count = Integer.bitCount(num);

        while (count != ones) {
            num++;
            count = Integer.bitCount(num);
        }

        return num;
    }
}