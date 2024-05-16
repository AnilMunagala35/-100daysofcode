class Solution {
    public int maxPath(TreeNode root,int ans[]){
        if(root==null){
            return 0;
        }
        int ls = maxPath(root.left,ans);
        if(root.left!=null){
            ans[0] = Math.max(ans[0],ls);
        }
        int rs = maxPath(root.right,ans);
        if(root.right!=null){
            ans[0] = Math.max(ans[0],rs);
        }
        ans[0] = Math.max(ans[0],root.val+ls+rs);
        ans[0] = Math.max(ans[0],root.val+ls);
        ans[0] = Math.max(ans[0],root.val+rs);
        ans[0] = Math.max(ans[0],root.val);
        int a = Math.max(root.val + ls , root.val + rs);
        return Math.max(a,root.val);
            
    }
    public int maxPathSum(TreeNode root) {
        int ans[] = {Integer.MIN_VALUE};
        int wr = maxPath(root,ans);
        return ans[0];
    }
}
