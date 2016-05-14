public class Solution {

    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num <= 5) return true;

        int root = (int) Math.sqrt(num);
        for (int a = 2; a <= root; a++) {
            if (num % a == 0) {
                if ((isPrime(a) && a > 5) || (isPrime(num / a) && (num / a) > 5)) return false;
            }
        }
        return !isPrime(num);
    }

    public boolean isPrime(int num) {
        int root = (int) Math.sqrt(num);
        for (int a = 2; a <= root; a++) {
            if (num % a == 0) return false;
        }
        return true;
    }
}