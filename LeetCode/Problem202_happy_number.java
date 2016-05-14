public class Solution {
    public boolean isHappy(int n) {
        if (n > 1 && n < 10) return false;
        int num = n;
        Set<Integer> set = new HashSet<>();
        do {
            int log = (int) Math.log10(num), sum = 0;
            for (int a = log; a >= 0; a--) {
                int pow = (int) Math.pow(10, a);
                sum += Math.pow(num / pow, 2);
                num %= pow;
            }
            if (set.contains(sum)) return false;
            num = sum;
            set.add(num);
        } while (num != 1);
        return true;
    }
}