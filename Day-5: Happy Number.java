class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=sq(slow);
            fast=sq(sq(fast));
            if(fast==1){
                return true;
            }
        }while(slow!=fast);
        return false;
    }
    static int sq(int n){
        int rem=0;
        int sum=0;
        while(n>0){
            rem=n%10;
            sum+=rem*rem;
            n=n/10;
        }
        return sum;
    }
}
