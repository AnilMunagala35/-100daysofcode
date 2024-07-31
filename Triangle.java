
class Solution {
    Integer[][] dp;
    public int f(List<List<Integer>> lt,int i,int j){
        if(i>=lt.size()) return Integer.MAX_VALUE;
        if(j>=lt.get(i).size()) return Integer.MAX_VALUE;
        if(dp[i][j]!=null) return dp[i][j];
        int x=Math.min(f(lt,i+1,j),f(lt,i+1,j+1));
        if(x!=Integer.MAX_VALUE) dp[i][j]=lt.get(i).get(j)+x;
        else  dp[i][j]=lt.get(i).get(j);
        return   dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        dp=new Integer[triangle.size()][triangle.size()];
        return f(triangle,0,0);
    }
}
