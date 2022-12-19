class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans=0;
        
        int[] count=getCharArray(chars);
        
        for(String word:words){
            int[] arr=getCharArray(word);
            
            boolean consider=true;
            for(char c:word.toCharArray()) if(arr[c-'a']>count[c-'a']) consider=false;
            
            if(consider) ans+=word.length();
        }
        
        return ans;
    }
    
    
    private int[] getCharArray(String str){
        int[] count=new int[26];
        
        for(char c:str.toCharArray()) count[c-'a']++;
        
        return count;
    }
    
    
}
