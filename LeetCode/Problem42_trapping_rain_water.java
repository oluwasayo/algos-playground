import java.util.ArrayDeque;
public class Solution {

    public int trap(int[] heights) {
        int lo = 0, hi = heights.length - 1, section = 0, volume = 0;
        while (lo < hi) {
            if (heights[lo] < heights[hi]) {
                section = section = Math.max(section, heights[lo])
                volume += section - heights[lo++];
            } else {
                section = section = Math.max(section, heights[hi]);
                volume += section - heights[hi--];
            }
        }
        return volume;
    }

    private class Pair {
        int p, h;
        private Pair(int p, int h) { this.p = p; this.h = h; }
    }
}

/* CONDENSED SOLUTION. */
// public int trap(int[] H) {
//     int lo = 0, hi = H.length - 1, sec = 0, v = 0;
//     while (lo < hi) v += H[lo] < H[hi] ? (sec = Math.max(sec, H[lo])) - H[lo++] : (sec = Math.max(sec, H[hi])) - H[hi--];
//     return v;
// }

/* SOLUTION WITH STACK. */
// public int trap(int[] heights) {
//     if (heights.length == 0) return 0;
//     ArrayDeque<Pair> deque = new ArrayDeque<>();
//     deque.push(new Pair(0, heights[0]));
//         int volume = 0, lph = 0; // Last popped height.
//         for (int a = 1; a < heights.length; a++, lph = 0) {
//             if (deque.size() == 1 && heights[a] >= deque.peek().h) deque.pop();
//             boolean cont = false;
//             while (!deque.isEmpty() && (heights[a] > deque.peek().h || cont)) {
//                 lph = cont ? lph : deque.pop().h;
//                 volume += (Math.min(deque.peek().h, heights[a]) - lph) * (a - deque.peek().p - 1);
//                 cont = heights[a] > deque.peek().h;
//                 lph = !deque.isEmpty() && heights[a] >= deque.peek().h ? deque.pop().h : heights[a];
//             }
//             deque.push(new Pair(a, heights[a]));
//         }
//         return volume;
//     }