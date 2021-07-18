package Java;

public class StackArray {
    static final int MAX =1000000;
    int top;
    int stack[] = new int[MAX];

    StackArray(){
        top = -1;
    }


    boolean isEmpty(){

        return (top < 0);
    }

    boolean push(int data){
        if(top>=MAX-1){
            System.out.println("Stack Overflow");
            return false;
        }
        stack[++top] = data;
        System.out.println(data + " pushed to the top of the stack");
        return true;

    }

    int pop(){
        if(top<0){
            System.out.println("Stack Underflow");
            return -MAX -1;
        }

        return stack[--top];


    }


    int peek(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -MAX - 1;
        }
        return stack[top];
    }


}
