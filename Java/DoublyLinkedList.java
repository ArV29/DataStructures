class DoublyLinkedList{
  Node head;
  int length;

  DoublyLinkedList(){
    head = null;
    length = 0;
  }

  int count(){
    int c = 0;
    Node temp = this.head;
    while (temp!=null){
      temp = temp.next;
      c++;
    }
    return c;
  }

  void display(){
    Node temp = head;
    while(temp!=null){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  private void push(int data){
    Node node = new Node(data);
    Node head = this.head;
    this.head = node;
    this.head.next = head;
    head.prev = this.head;
    length++;
    display();
   
  }
  private void append(int data){
    Node node = new Node(data);
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.next = node;
    node.prev = temp;
    length++;
    display();
  }
  void insert(int data, int index){
    Node temp = head;
    if(length == 0){
      head = new Node(data);
      length ++;
      display();
    }
    else if(index == 0){
      push(data);
    }
    else if(index == length){
      append(data);
    }
    else{
      int i = 0;
      Node node = new Node(data);
      while(i<index){
        temp = temp.next;
        i++;
      }
      node.next = temp;
      node.prev = temp.prev;
      temp.prev.next = node;
      temp.prev = node; 
      length++;
      display();
    }
  }
  private int pop(){
    Node temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.prev.next = null;
    length --;
    display();
    return temp.data;
  }

  int remove(int index){
    if(index>=length){
      System.out.println("Invalid Operation");
      return Integer.MIN_VALUE;
    }
    if(index == 0){
      Node temp =head;
      head = head.next;
      head.prev = null;
      length--;
      display();
      return temp.data;
    }
    else if(index == length -1){
      return pop();
    }
    else{
      int i = 0;
      Node temp = head;
      while(i<index){
        temp = temp.next;
        i++;
      }
      temp.prev.next = temp.next;
      temp.next.prev = temp.prev;
      length--;
      display();
      return temp.data;
    }
  }

  public static void main(String[] args) {
    DoublyLinkedList dLL = new DoublyLinkedList();
    dLL.insert(1, 0);
    dLL.insert(3, 1);
    dLL.insert(2, 1);
    dLL.insert(0, 0);
    System.out.println(dLL.count());
    dLL.remove(3);
    dLL.remove(1);
    dLL.remove(0);
    }



}
class Node{
  int data;
  Node next, prev;

  Node(int data) {
    this.data = data;
    next = null;
    prev = null;
  }
}