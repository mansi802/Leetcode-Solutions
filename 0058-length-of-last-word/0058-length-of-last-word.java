class Solution {
    public int lengthOfLastWord(String s) {
        
        String[] str=s.split(" ");
        int n=str.length;
        if(str.length==0) return 0;
        
        return str[n-1].length();
        
    }
}