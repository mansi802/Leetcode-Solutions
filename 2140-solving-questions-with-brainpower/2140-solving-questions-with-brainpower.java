class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] memo=new long[n+1];
        
        for(int i=n-1;i>=0;i--){
            long notTake=memo[i+1];
            int next=questions[i][1]+i+1;
            long take=questions[i][0];
            if(next<=n) take+=memo[next];
            
            memo[i]=Math.max(take,notTake);
        }
        
        
        return memo[0];
        // return helper(questions,0);
    }
    
    private int helper(int[][] questions,int i){
        if(i>=questions.length) return 0;
        
        int notTake=helper(questions,i+1);
        int take=questions[i][0]+helper(questions,i+questions[i][1]+1);
        
        return Math.max(take,notTake);
    }
}