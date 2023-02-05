class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        
        List<Integer> ans=new ArrayList<>();
        
        int[] occ=new int[26];
        int[] ref=new int[26];
        for(char c:p.toCharArray()) occ[c-'a']++;
        
        for(int i=0;i<n;i++){
            
            ref[s.charAt(i)-'a']++;
            
            if(i-m>=0){
                ref[s.charAt(i-m)-'a']--;
            }
            
            if(Arrays.equals(ref,occ)) ans.add(i-m+1);
        }
        
        return ans;
    }
}