// Abdalla Abdelmagid

public class Stack {
    private int[] elements;
    private int top;
    public Stack() {
    // inits to empty stack
    elements = new int[16];
    top = -1;
    }
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (top == 15) {
            return true;
        } else {
            return false;
        }
    }

    public int pop(int num) {
        elements[top] = num;
        num++;
        return num;
    }

    public void push(int num) {
        elements[top] = num;
        num--;
    }
}