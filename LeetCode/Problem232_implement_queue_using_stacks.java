class MyQueue {

    Deque<Integer> left = new ArrayDeque<>();
    Deque<Integer> right = new ArrayDeque<>();
    boolean isViewing = false;

    public void push(int x) {
        if (isViewing) while(!left.isEmpty()) right.push(left.pop());
        isViewing = false;
        right.push(x);
    }

    public void pop() {
        if (!isViewing) while (!right.isEmpty()) left.push(right.pop());
        isViewing = true;
        left.pop();
    }

    public int peek() {
        if (!isViewing) while (!right.isEmpty()) left.push(right.pop());
        isViewing = true;
        return left.peek();
    }

    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }
}