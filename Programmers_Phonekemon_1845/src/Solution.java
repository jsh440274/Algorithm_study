import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int answer = 0;
        if (nums.length / 2 < map.keySet().size()) {
            answer = nums.length / 2;
        } else {
            answer = map.keySet().size();
        }

        return answer;
    }
}