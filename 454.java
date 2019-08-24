class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for (int j =  0; j < D.length; j++) {
                map.put(C[i] + D[j], map.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }

        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j =  0; j < B.length; j++) {
                result += map.getOrDefault(-(A[i] + B[j]), 0);
            }
        }
        return result;
    }
}