class Solution {
    public int candy(int[] ratings) {
        Stack<int[]> stk = new Stack<>();
        int prev = -1;
        int val = -1;
        int count = 0;
        for(int i : ratings){
            if(stk.size() == 0 || stk.peek()[0] >= i)
                // Each child must have at least one candy
                stk.push(new int[]{i , 1});
                
            
            else if(stk.peek()[0] < i)
                stk.push(new int[]{i , stk.peek()[1] + 1});
                
          }

        while(stk.size() > 0){
            if(prev == -1 || stk.peek()[0] <= prev)
            {  int[] temp = stk.pop();
                prev = temp[0];
                val = temp[1];
            }
            else if(prev < stk.peek()[0]){
                if(val >= stk.peek()[1])
                {
                    prev = stk.pop()[0];
                    val = val + 1;
                }
                else
                 {  int[] temp = stk.pop();
                prev = temp[0];
                val = temp[1];
                }
            }
            count += val;
        }
        return count;
        
    }
}
