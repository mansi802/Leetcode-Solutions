class Solution {
    public int[] closestPrimes(int left, int right) {
       int f = -1, s = -1;
        int[] r = {-1, -1};
        if (left <= 2) {
            f = 2;
            left = 3;
        }
        if (left % 2 == 0) {
            left++;
        }
        for (int i = left; i <= right; i = i + 2) {
            if (f > 1 && s > 1 && s - f <= 2) {
                r[0] = f;
                r[1] = s;
                return r;
            }

            if (prime(i)) {
                if (f == -1) {
                    f = i;
                } else if (s == -1) {
                    s = i;
                } else {
                    if (r[1] == r[0] || r[1] - r[0] > s - f) {
                        r[0] = f;
                        r[1] = s;
                    }
                    f = s;
                    s = i;
                }
            }

        }
        if (f > 1 && s > 1 && (r[1] == r[0] || r[1] - r[0] > s - f)) {
            r[0] = f;
            r[1] = s;
        }
        return r;
    }
    
     public boolean prime(int n){
          if(n==1){
            return false;
          }
          for(int i=2;i*i<=n;i++){
            if(n%i==0){
              return false;
            }
          }
          return true;
    }
}