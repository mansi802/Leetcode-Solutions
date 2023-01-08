class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean Bulky=isBulky(length,width,height);
        boolean Heavy=mass>=100;
        
//         If the box is both "Bulky" and "Heavy", then its category is "Both".
// If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
// If the box is "Bulky" but not "Heavy", then its category is "Bulky".
// If the box is "Heavy" but not "Bulky", then its category is "Heavy".
        
        if(Bulky && Heavy) return "Both";
        else if(!Bulky && !Heavy) return "Neither";
        else if(Bulky && !Heavy) return "Bulky";
        else if(Heavy && !Bulky) return "Heavy";
        
        return "";
    }
    
    private boolean isBulky(int l,int w,int h){
        long vol=(long)l*(long)w*(long)h;
        
        if(vol>=1000_000_000) return true;
        
        if(l>=10000 || w>=10000 || h>=10000) return true;
        
        return false;
    }
}