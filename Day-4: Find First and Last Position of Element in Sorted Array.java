class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = left(nums, target);
        ans[1] = right(nums, target);
        return ans;
    }

    static int left(int[] nums, int t) {
        int s = 0;
        int e = nums.length - 1;
        int result = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == t) {
                result = mid;
                e = mid - 1;
            } else if (nums[mid] < t) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return result;
    }

    static int right(int[] nums, int t) {
        int s = 0;
        int e = nums.length - 1;
        int result = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == t) {
                result = mid;
                s = mid + 1;
            } else if (nums[mid] < t) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return result;
    }
}
