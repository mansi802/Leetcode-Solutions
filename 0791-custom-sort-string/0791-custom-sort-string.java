class Solution {
    public String customSortString(String order, String s) {
        int[] count=new int[26];
        
        for(char c:s.toCharArray()) count[c-'a']++;
        
        StringBuilder str=new StringBuilder();
        
        for(char c:order.toCharArray()){
            while(count[c-'a']-->0) str.append(c);
        }
        
        for(char c:s.toCharArray()){
            while(count[c-'a']-->0) str.append(c);
        }
        
        return str.toString();
    }
}