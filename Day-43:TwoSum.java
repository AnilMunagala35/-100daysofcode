class Solution {
    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        //hashmap to stored the value 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            // if map conatains remaining value just return the index
            if(map.containsKey(nums[i])){
                arr[0] = map.get(nums[i]);
                arr[1] = i;
                // just return the arr
                 return arr;
            }
            else{
                // (target - value) -> remaining value which is equal to target sum 
                map.put((target - nums[i]), i);
            }
        }
        return arr;
    }
}
