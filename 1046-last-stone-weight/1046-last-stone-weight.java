class Solution {
    public int lastStoneWeight(int[] stones) {
       List<Integer> list=new ArrayList<>();
           
        for(int i:stones){
            list.add(i);
        }
        
        while(list.size()>1){
            Collections.sort(list,Collections.reverseOrder());
            
            if(list.size()>2 && list.get(0)==list.get(1))
            {
                list.remove(1);
                list.remove(0);     
            }else{
                int n=Math.abs(list.get(1)-list.get(0));
                list.remove(1);
                list.remove(0);
                 list.add(n);
            }
        }
        
        return list.get(0); 
    }
}