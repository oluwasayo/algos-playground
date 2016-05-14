import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Deque<Integer> ss, cs, rs;
        ss = new ArrayDeque<Integer>();
        cs = new ArrayDeque<Integer>();
        rs = new ArrayDeque<Integer>();
        for (int a = 0; a < s.length(); a++) {
            int val = 0;
            try {
            switch (s.charAt(a)) {
                case '[':
                    val = ss.isEmpty() ? 0 : ss.pop();
                    ss.push(val + 1);
                    cs.push(0);
                    rs.push(0);
                    break;
                case '{':
                    val = cs.isEmpty() ? 0 : cs.pop();
                    cs.push(val + 1);
                    ss.push(0);
                    rs.push(0);
                    break;
                case '(':
                    val = rs.isEmpty() ? 0 : rs.pop();
                    rs.push(val + 1);
                    ss.push(0);
                    cs.push(0);
                    break;
                case ']':
                    ss.push(ss.pop() - 1);
                    if (cs.pop() != 0 || rs.pop() != 0)
                        return false;
                    break;
                case '}':
                    cs.push(cs.pop() - 1);
                    if (ss.pop() != 0 || rs.pop() != 0)
                        return false;
                    break;
                case ')':
                    rs.push(rs.pop() - 1);
                    if (ss.pop() != 0 || cs.pop() != 0)
                        return false;
                    break;
                default:
                    System.out.println("I know thee not!");
            }
            } catch (NoSuchElementException ex) {
                return false;
            }
        }
        return (ss.isEmpty() || ss.pop() == 0) && (cs.isEmpty() || cs.pop() == 0) && (rs.isEmpty() || rs.pop() == 0);
    }
}