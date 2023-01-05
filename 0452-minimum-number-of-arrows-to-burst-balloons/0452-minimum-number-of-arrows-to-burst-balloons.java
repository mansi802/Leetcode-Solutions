class Solution {
    //optimised version
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        
        if(n==0 || n==1) return n;
        Arrays.sort(points,(p1,p2)->Integer.compare(p1[0],p2[0]));
        int last=points[0][1];
        int count=1;
        for(int[] p:points){
            if(last>=p[0]){
                last=Math.min(last,p[1]);
            }else{
                last=p[1];
                count++;
            }
        }
        
        return count;
    }
}