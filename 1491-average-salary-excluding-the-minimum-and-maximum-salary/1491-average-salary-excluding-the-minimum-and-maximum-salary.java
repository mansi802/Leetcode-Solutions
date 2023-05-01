class Solution {
    public double average(int[] salary) {
        int n=salary.length;
        double sum=0;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        
        for(int s:salary){
            min=Math.min(min,s);
            max=Math.max(max,s);
        }
        
        for(int s:salary) sum+=s;
        
        return (sum-min-max)/(n-2);
    }
}