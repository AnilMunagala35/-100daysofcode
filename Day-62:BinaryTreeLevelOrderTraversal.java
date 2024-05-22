class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outer = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        if (root == null) return outer;

        level.add(root);
        while (true) {
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> levelVal = new ArrayList<>();
            for (TreeNode chicken : level) {
                levelVal.add(chicken.val);
            }
            outer.add(levelVal);
            for (TreeNode cur : level) {
                if (cur.left != null) nextLevel.add(cur.left);
                if (cur.right != null) nextLevel.add(cur.right);
            }
            level = nextLevel;
            if (nextLevel.isEmpty()) break;
        }
        return outer;
    }
}
