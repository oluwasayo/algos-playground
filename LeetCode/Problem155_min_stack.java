class MinStack {

    Node tail = null;

    public void push(int x) {
        if (tail == null) tail = new Node(x, x, null);
        else tail = new Node(x, Math.min(x, tail.min), tail);
    }

    public void pop() {
        tail = tail.prev;
    }

    public int top() {
        return tail.element;
    }

    public int getMin() {
        return tail.min;
    }

    private class Node {
        private int element, min;
        private Node prev;
        private Node(int element, int min, Node prev) {
            this.element = element;
            this.min = min;
            this.prev = prev;
        }
    }
}
