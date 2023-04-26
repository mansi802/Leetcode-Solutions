class Solution {
    public int alternateDigitSum(int n) {
        String s=n+"";
        
        int i=0;
        int len=s.length();
        int sum1=0,sum2=0;
        while(i<len){
            sum1+=(s.charAt(i)-'0');
            i++;
            
            if(i<len){
                sum2+=(s.charAt(i)-'0');
                i++;
            }
        }
        
        return sum1-sum2;
    }
}