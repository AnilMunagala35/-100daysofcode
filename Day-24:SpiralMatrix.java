class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int left = 0;
        ArrayList<Integer> li = new ArrayList<>();
        while (left <= right && top <= down) {
            for (int i = left; i <= right; i++) {
                li.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= down; i++) {
                li.add(matrix[i][right]);
            }
            right--;
            if (top <= down) {
                for (int i = right; i >= left; i--) {
                    li.add(matrix[down][i]);
                }
            }
            down--;
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    li.add(matrix[i][left]);
                }
            }
            left++;
        }
        return li;
    }
}
