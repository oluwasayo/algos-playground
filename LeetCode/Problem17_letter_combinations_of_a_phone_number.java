public class Solution {
    int len = 0;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();

        len = digits.length();
        List<Node> leafs = new ArrayList<Node>();
        Node root = new Node('\u0000');
        leafs.add(root);
        for (int a = 0; a < digits.length(); a++) {
            char c = digits.charAt(a);
            List<Node> nextGen = new ArrayList<Node>();
            for (Node n : leafs) {
                List<Node> localNextGen = nodes(c);
                n.children.addAll(localNextGen);
                nextGen.addAll(localNextGen);
            }
            leafs = nextGen;
        }

        StringBuilder buffer = new StringBuilder();
        explore(root, buffer, new ArrayList<Character>());
        String[] arr = buffer.toString().split(" ");
        arr = arr.length == 1 && "".equals(arr[0]) ? new String[0] : arr;
        return Arrays.asList(arr);
    }

    private List<Node> nodes(char c) {
        String str;
        switch (c) {
            case '2':
                str = "abc"; break;
            case '3':
                str = "def"; break;
            case '4':
                str = "ghi"; break;
            case '5':
                str = "jkl"; break;
            case '6':
                str = "mno"; break;
            case '7':
                str = "pqrs"; break;
            case '8':
                str = "tuv"; break;
            case '9':
                str = "wxyz"; break;
            default:
                str = "";
        }

        List<Node> result = new ArrayList<Node>(str.length());
        for (char car : str.toCharArray()) {
            result.add(new Node(car));
        }
        return result;
    }

    private void explore(Node n, StringBuilder buffer, List<Character> cars) {
        boolean added = false;
        if (n.value != '\u0000') {
            cars.add(n.value);
            added = true;
        }

        if (cars.size() == len) {
            for (char c : cars) {
                buffer.append(c);
            }
            buffer.append(" ");
        }

        for (Node child : n.children) {
            explore(child, buffer, cars);
        }

        if (added) { cars.remove(cars.size() - 1); }
    }

    class Node {
        char value;
        List<Node> children;
        Node(char c) {
            value = c;
            children = new ArrayList<Node>();
        }
    }
}