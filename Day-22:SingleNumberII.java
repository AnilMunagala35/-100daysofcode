class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int shift = 1;
        for (int i = 0; i < 32; ++i) {
            int c = 0;
            for (int x : nums) {
                if ((x & shift) == shift) {
                    c += 1;
                }
            }
            if (c % 3 != 0)
                ans += shift;
            shift *= 2;

        }
        return ans;
    }
}
