import java.util.*;
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (!map.containsKey(s)) map.put(s, new PriorityQueue<String>());
            map.get(s).add(str);
        }

        List<List<String>> result = new ArrayList<>(map.size());
        for (PriorityQueue<String> queue : map.values()) {
            List<String> line = new ArrayList<String>();
            while (!queue.isEmpty()) line.add(queue.remove());
            result.add(line);
        }

        return result;
    }
}