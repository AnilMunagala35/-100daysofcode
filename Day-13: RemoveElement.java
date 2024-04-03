class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val && nums[j] != val) {
                swap(nums, i, j);
                i++;
                j--;
            }
            if (nums[j] == val) {
                j--;
            }
            if (nums[i] != val) {
                i++;
            }

        }
        if (i > nums.length) {
            return i - 1;
        }
        return i;
    }

    static void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}
