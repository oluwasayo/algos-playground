public class Solution {
    final Map<Character, Integer> map = new HashMap<Character, Integer>();

    public Solution() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int lastPos = 0, count = 0;
        int sum = 0, lastSum = 0;
        boolean b = false;
        for (int a = 0; a < s.length(); a++) {
            //System.out.printf("I -- Sum:%d, lastSum=%d\n", sum, lastSum);
            if (a == 0) {
                if (a == chars.length - 1 || map.get(chars[a+1]) <= map.get(chars[a])) {
                    sum += map.get(chars[a]);
                    lastSum = 0;
                } else {
                    lastSum = map.get(chars[a]);
                    b = true;
                }
            } else if (map.get(chars[a]) > map.get(chars[a-1])) {
                sum += map.get(chars[a]) - lastSum;
                lastSum = 0;
            } else if (map.get(chars[a]) == map.get(chars[a-1])) {
                sum += map.get(chars[a]);
                lastSum = 0;
            } else if (map.get(chars[a]) < map.get(chars[a-1])) {
                if (a == chars.length - 1 || map.get(chars[a+1]) <= map.get(chars[a])) {
                    sum += map.get(chars[a]);
                    lastSum = 0;
                } else {
                    lastSum = map.get(chars[a]);
                    b = true;
                }
            }
        }
        //System.out.printf("Sum:%d, lastSum=%d\n", sum, lastSum);

        return sum + (b ? lastSum : 0);
    }
}