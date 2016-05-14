public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<Line> lines = new ArrayList<>();
        Line curr = new Line();
        for (String word : words) {
            if (curr.len != 0 && (curr.len + word.length() >= maxWidth)) {
                lines.add(curr);
                curr = new Line();
            }
            curr.add(word);
        }
        lines.add(curr);

        List<String> result = new ArrayList<>();
        StringBuilder sb;
        for (int a = 0; a < lines.size() - 1; a++) {
            sb = new StringBuilder();
            Line line = lines.get(a);
            if (line.words.size() <= 2) {
                sb.append(line.words.get(0));
                for (int b = 0; b < maxWidth - line.len; b++) sb.append(' ');
                if (line.words.size() == 2) sb.append(' ').append(line.words.get(1));
            } else {
                int pad = (maxWidth - line.len) / (line.words.size() - 1);
                int boost = (maxWidth - line.len) % (line.words.size() - 1);
                int count = 0;
                for (int b = 0; b < line.words.size() - 1; b++) {
                    sb.append(line.words.get(b));
                    for (int c = 0; c <= pad; c++) sb.append(' ');
                    if (count++ < boost) sb.append(' ');
                }

                sb.append(line.words.get(line.words.size() - 1));
            }

            result.add(sb.toString());
        }

        sb = new StringBuilder();
        Line line = lines.get(lines.size() - 1);
        for (int a = 0; a < line.words.size() - 1; a++) {
            sb.append(line.words.get(a)).append(' ');
        }
        sb.append(line.words.get(line.words.size() - 1));
        for (int a = 0; a < maxWidth - line.len; a++) sb.append(' ');

        result.add(sb.toString());
        return result;
    }

    private static class Line {
        private List<String> words;
        private int len;
        private Line() {
            words = new ArrayList<>();
        }
        private int add(String word) {
            words.add(word);
            len += words.size() == 1 ? word.length() : word.length() + 1;
            return len;
        }
    }
}