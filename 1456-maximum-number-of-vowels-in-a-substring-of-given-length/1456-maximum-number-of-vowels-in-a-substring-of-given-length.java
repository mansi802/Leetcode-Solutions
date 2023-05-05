class Solution {
    public int maxVowels(String s, int k) {
        int ans=0;
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            
            if(vowel(s.charAt(i))) cnt++; 
            
            if(i-k>=0 && vowel(s.charAt(i-k))) cnt--;
            
            ans=Math.max(ans,cnt);
        }
        
        return ans;
    }
    
    private boolean vowel(char c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}