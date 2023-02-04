class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k=s1.length();
        
        int[] count=new int[26];
        for(char c:s1.toCharArray()) count[c-'a']++;
        
        int[] curr=new int[26];
        for(int i=0;i<s2.length();i++){
            curr[s2.charAt(i)-'a']++;
            
            if(i-k>=0) curr[s2.charAt(i-k)-'a']--;
            
            if(Arrays.equals(count,curr)) return true;
        }
        
        return false;
    }
}