public class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        // TODO(oluwasayo): Make this a static TreeSet field so it
        // won't have to be recomputed from scratch everytime.
        List<Integer> primes = new ArrayList<>();
        outer: for (int a = 2; a < n; a++) {
            for (Integer b : primes) {
                if (b > Math.sqrt(a)) break;
                if (a % b == 0) continue outer;
            }
            primes.add(a);
        }
        return primes.size();
    }
}