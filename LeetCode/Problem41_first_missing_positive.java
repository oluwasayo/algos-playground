public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int a = 0; a < A.length; a++) {
            int des = A[a] - 1;
            if (des >= 0 && des < A.length && des != a /* meaningless swap */ && A[des] != A[a] /* infinite loop */) {
                swap(A, a--, des);
            }
        }

        for (int a = 0; a < A.length; a++) if (A[a] != a + 1) return a + 1;
        return A.length + 1;
    }

    private void swap(int[] A, int start, int end) {
        int temp = A[start]; A[start] = A[end]; A[end] = temp;
    }
}