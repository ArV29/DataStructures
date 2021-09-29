public class StackLinkedList {
    StackNode top;

    StackLinkedList(){
        top = null;
    }

    boolean isEmpty(){
        return (top == null);

    }


    void push(int data){
        StackNode temp = this.top;
        this.top = new StackNode(data);
        this.top.next = temp;
        System.out.println(data + " pushed to stack");
        
    }

    int pop(){
        


        int data = this.top.data;
        this.top = this.top.next;
        return data;

    }

    int peek(){

        if (this.top == null) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }
        return this.top.data;

    }



}

class StackNode{
    int data;
    StackNode next;

    StackNode(int val){
        this.data =val;
        this.next = null;
    }


}