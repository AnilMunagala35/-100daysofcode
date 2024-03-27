class Solution {
    public int removeDuplicates(int[] nums) {
        int s = 0;
        int f = 1;
        while (f < nums.length) {
            if (nums[s] == nums[f]) {
                f++;
            } else {
                s++;
                swap(nums, s, f);
                f++;
            }
        }
        return s + 1;
    }

    static void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}
