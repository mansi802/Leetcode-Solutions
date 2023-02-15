class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0 || K > 0; --i) {
            res.add(0, (i >= 0 ? A[i] + K : K) % 10);
            K = (i >= 0 ? A[i] + K : K) / 10;
        }
        return res;
    }
}