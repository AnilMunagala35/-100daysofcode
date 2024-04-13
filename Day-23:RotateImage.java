class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int k=0;k<matrix.length;k++){
            int s=0;
            int e=matrix[k].length-1;
            while(s<e){
                int temp = matrix[k][s];
                matrix[k][s] = matrix[k][e];
                matrix[k][e] = temp;
                s++;
                e--;
            }
        }
    }
}
