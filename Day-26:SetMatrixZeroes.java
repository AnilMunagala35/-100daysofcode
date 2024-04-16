class Solution {
    public void setZeroes(int[][] a) {
        int m=a.length;
        int n=a[0].length;
        boolean col0=false,row0=false;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]==0)
                {
                    if(i!=0 && j!=0)
                    {
                        a[0][j]=0;
                        a[i][0]=0;
                    }
                    if(i==0)
                    {
                        col0=true;
                    }
                    if(j==0)
                    {
                        row0=true;
                    }
                }
            }
        }
        for(int i=1;i<m;i++)
        {
            if(a[i][0]==0)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++)
        {
            if(a[0][i]==0)
            {
                for(int j=0;j<m;j++)
                {
                    a[j][i]=0;
                }
            }
        }
        if(row0)
        {
            for(int i=0;i<m;i++)
            {
                a[i][0]=0;
            }
        }
        if(col0)
        {
            for(int i=0;i<n;i++)
            {
                a[0][i]=0;
            }
        }
    }
}
