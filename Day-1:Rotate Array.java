//Rotate Array
class Solution {
    public void rotate(int[] nums, int k) {
        int s=nums.length-1;
        k=k%nums.length;
        reverse(nums,0,s-k);
        reverse(nums,s-k+1,s);
        reverse(nums,0,s);
    }
    static void reverse(int[] num, int s,int e){
        while(s<=e){
            int temp = num[s];
            num[s]=num[e];
            num[e]=temp;
            s++;
            e--;
        }
    }
}
