class Solution {
    public int distinctPrimeFactors(int[] nums) {
        int primeFactor = 2;
        HashSet<Integer> hs = new HashSet<>();
        for(Integer num: nums) {
            while(num != 1) {
                 if (num % primeFactor == 0){
                     num /= primeFactor;
                     hs.add(primeFactor);
                }else{
                     primeFactor += 1;
                     if(isPrime(primeFactor) == false){
                        primeFactor += 1;
                    }
                 }
              }
              primeFactor = 2;
          }
        return hs.size();
    }

    public boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}