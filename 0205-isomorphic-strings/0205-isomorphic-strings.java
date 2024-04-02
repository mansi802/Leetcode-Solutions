class Solution {
    public boolean isIsomorphic(String str1, String str2) {
        int size=256;
        int n=str1.length();
        int m=str2.length();
        
        if(n!=m) return false;
        
        Boolean[] marked = new Boolean[size];
        Arrays.fill(marked, Boolean.FALSE);
       
        int[] map = new int[size];
        Arrays.fill(map, -1);
         
        for (int i = 0; i < n; i++)
        {
            if (map[str1.charAt(i)] == -1)
            {
                if (marked[str2.charAt(i)] == true)
                    return false;
                
                marked[str2.charAt(i)] = true;
 
                map[str1.charAt(i)] = str2.charAt(i);
            }
            else if (map[str1.charAt(i)] != str2.charAt(i)) return false;
        }
        
        return true;
    }
}