public class StackArray {
    int MAX;
    int top;
    int stack[];

    StackArray(int length) {
        top = -1;
        MAX = length;
        stack = new int[MAX];
    }

    boolean isEmpty() {
        return (top < 0);
    }

    boolean isFull(){
        return top == MAX-1;
    }

    boolean push(int data) {
        if (top >= MAX - 1) {
            System.out.println("Error: Stack Overflow");
            return false;
        }
        stack[++top] = data;
        System.out.println(data + " pushed to the top of the stack");
        return true;
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -MAX - 1;
        }
        System.out.println(stack[top] + " popped from top of the stack");
        return stack[top--];
    }

    int peek() {
        if (top < 0) {
            System.out.println("Error: Stack Underflow");
            return -MAX ;
        }
        return stack[top];
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + ' ');
        }
    }
    public static void main(String args[]) {
        StackArray stack = new StackArray(10000);
        
        System.out.println("Is the stack empty?\t" + stack.isEmpty());
	    stack.push(10);
	    stack.push(20);
	    stack.pop();
	    System.out.println("Topmost element: " + stack.peek());
	    System.out.println("Is the stack Full?\t" + stack.isFull());
	    stack.pop();
	    System.out.println("Is the stack empty?\t" + stack.isEmpty());
	    System.out.println("Topmost element: " + ((stack.peek() !=-stack.MAX)?stack.peek() :"NA"));

    }
}
