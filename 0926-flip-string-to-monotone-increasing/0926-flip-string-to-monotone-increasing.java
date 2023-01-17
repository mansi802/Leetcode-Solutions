class Solution {
    public int minFlipsMonoIncr(String s) {
        int count1=0,count0=0;
        boolean found1=false;
        
        for(char c:s.toCharArray()){
            if(found1){
                if(c=='0')
                    count0++;
                else
                    count1++;
                
                if(count0>count1)
                    count0=count1;
            }
            else if(c=='0') continue;
            
            else if(c=='1'){
                count1++;
                found1=true;
            }
        }
        
        return count0;
    }
}