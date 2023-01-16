class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list=new ArrayList<>();
        
        for(int[] i:intervals){
            if(newInterval==null || i[1]<newInterval[0]) list.add(i);
            else if(i[0]>newInterval[1]){
                list.add(newInterval);
                list.add(i);
                newInterval=null;
            }else{
                newInterval[0] = Math.min(newInterval[0], i[0]);//get min
                 newInterval[1] = Math.max(newInterval[1], i[1]);//get max
            }
        }
        
        if(newInterval!=null) list.add(newInterval);
        
        return list.toArray(new int[list.size()][2]);
    }
}