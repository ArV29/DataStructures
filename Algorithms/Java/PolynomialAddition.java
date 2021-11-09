class PolynomialAddition{
    static LinkedList addPolynomial(LinkedList poly1, LinkedList poly2){
        LinkedList result = new LinkedList();
        Node p1 = poly1.head;
        Node p2 = poly2.head;

        while(p1 != null && p2 != null){
            if(p1.pow > p2.pow){
                result.append(p1.coeff, p1.coeff);
                p1 = p1.next;
            }else if(p2.pow > p1.pow){
                result.append(p2.coeff, p1.pow);
                p2 = p2.next;
            }else{
                result.append(p1.coeff+p2.coeff, p1.pow);
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        while(p1 != null){
            result.append(p1.coeff, p1.coeff);
            p1 = p1.next;
        }

        while (p2 != null) {
            result.append(p2.coeff, p2.coeff);
            p2 = p2.next;
        }

        return result;
    }
    
    public static void main(String[] args) {
        LinkedList poly1 = new LinkedList();
        poly1.append(5, 5);
        poly1.append(1, 4);
        poly1.append(3, 3);
        poly1.append(1, 2);
        poly1.append(1, 1);

        LinkedList poly2 = new LinkedList();

        poly2.append(3, 4);
        poly2.append(1, 2);

        
        LinkedList sum = PolynomialAddition.addPolynomial(poly1, poly2);

        System.out.print("Polynomial 1:\t");
        poly1.print();
        System.out.print("Polynomial 2:\t");
        poly2.print();
        System.out.print("Sum P1  P2:\t");
        sum.print();
    }

}
class LinkedList {
    Node head;
    int length;

// Functions regarding accessing the value of the linked list

    // Print the whole list
    void print() {
        Node current = this.head;
        while (current != null) {
            if (current.coeff<0)
                System.out.print(current.coeff + "x" + "^"+current.pow+' ');
            else
                System.out.print("+"+current.coeff + "x" + "^"+current.pow+' ');

            current = current.next;
        }
        System.out.println();
    }

    //Get the data of the node at the specified index
    int[] get(int index){
        if (index < 0 || index > length) {
            System.out.println("Unable to add Node. IndexOutOfBounds");
            int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            return result;
        }
        Node temp = head;
        for(int i = 0; i<index ; i++){
            temp = temp.next;
        } 
        int[] result = new int[]{temp.coeff, temp.pow};
        return result;
    }

// Functions Regarding Addition Of A Node

    void append(int coeff, int pow) {
        if (head == null) {
            head = new Node(coeff ,pow);
            return;
        }
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(coeff ,pow);
        this.length++;
    }
    void push(int coeff, int pow) {
        Node newNode = new Node(coeff ,pow);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }
    Node pop() {
        if (this.length == 0) {
            System.out.println("Unable to remove Node. IndexOutOfBounds");
            return null;
        }

        Node temp = this.head;


        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node lastNode = temp.next;
        temp.next = null;
        return lastNode;
    }
}

class Node {
    Node next;
    int coeff , pow;

    Node(int coeff, int pow) {
        this.coeff = coeff;
        this.pow = pow;
        next = null;
    }

}
