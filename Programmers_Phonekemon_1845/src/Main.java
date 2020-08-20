public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums1 = {3,1,2,3};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,3,3,2,2,2};

        int res1 = s.solution(nums1);
        int res2 = s.solution(nums2);
        int res3 = s.solution(nums3);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

    }
}
