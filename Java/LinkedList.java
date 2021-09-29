class Node {
    Node next;
    int data;

    Node(int value) {
        this.data = value;
        next = null;
    }

}

class LinkedList {
    Node head;
    int length;

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.print();
    }

    LinkedList() {
        this.head = null;
        this.length = 0;
    }

    // Functions regarding accesing the value of the linked list

    // Print the whole list
    void print() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

    // Functions Regarding Addition Of A Node

    // Add a node to the back of the list
    void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
        this.length++;
    }

    // Add a node to the front of the list
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }

    // Add a node at the specified index in the list (used 0 based indexing)
    void insertAtIndex(int data, int index) {
        if (index < 0 || index > length) {
            System.out.println("Unable to add Node. IndexOutOfBounds");
            return;
        }
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node temp1 = null;
        if (temp.next != null) {
            temp1 = temp.next.next;
        }
        temp.next = new Node(data);
        temp.next.next = temp1;
        this.length++;
    }

    // Functions Regarding Removal of A Node

    // Remove the last node from the list and returns it
    Node pop() {
        if (this.length == 0) {
            System.out.println("Unable to remove Node. IndexOutOfBounds");
            return null;
        }

        Node temp = this.head;

        while (temp.next != null) {
            temp = temp.next;
        }
        Node lastNode = temp.next;
        temp.next = null;
        return lastNode;
    }

    // Functions Regarding Modification of the Linked List

    void reverse() {
        Node current = this.head;
        Node next;
        Node previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        this.head = previous;
    }
}
