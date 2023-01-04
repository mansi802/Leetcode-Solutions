class Solution {
    public int minimumRounds(int[] tasks) {
        int n=tasks.length;
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        
        int count=0;
        
        for(int key:map.keySet()){
            int val=map.get(key);
            
            while(val > 0) // for every key checking how many rounds will require
            { 
                // for ex 3 is a key and it occurs 5 times so checking 5 - 2 % 3 == 0 or not to get minimum rounds
                if(val > 3 && (val - 2) % 3 == 0) 
                {
                    count += val / 3;
                    val = val % 3;
                }
                
                else if(val % 3 == 0)
                {
                    count += val / 3;
                    val = val % 3;
                }
                else if(val >= 2)
                {
                    count++;
                    val -= 2;
                }      
                else // if val == 1 will return -1.
                {
                    return -1;
                }
            }
        }
        
        return count;
    }
}