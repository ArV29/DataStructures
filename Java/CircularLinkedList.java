class CircularLinkedList {
  Node last;
  int length;

  CircularLinkedList(){
    last = null;
    length = 0;
  }

  int count(){
    if(last == null){
      return 0;
    }
    Node temp = last;
    int c = 1;
    while(temp.next != last){
      c++;
      temp = temp.next;
    }
    return c;
  }
  void display(){
    Node temp = last.next;
    while(temp != last){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println(last.data);
  }
  private void push(int data){
    Node node = new Node(data);
    node.next = last.next;
    last.next = node;
    length++;
    display();
  }
  private void append(int data){
    Node node = new Node(data);
    node.next = last.next;
    last.next = node;
    last = node;
    length ++;
    display();
  }
  void insert(int data, int index){
    if(length == 0){
      Node node = new Node(data);
      this.last = node;
      last.next = node;
      length++;
      display();
    }
    else if(index == 0){
      push(data);
    }
    else if(index == length){
      append(data);
    }
    else{
      Node head = last.next;
      Node node = new Node(data);
      for(int i = 0; i<index-1;i++){
        head = head.next;
      }
      Node temp = head.next;
      head.next = node;
      node.next = temp;
      length++;
      display();
    }
  }
  private int pop(){
    Node head = last.next;
    while(head.next!=last){
      head = head.next;
    }
    head.next = last.next;
    Node node = last;
    last = head;
    length--;
    display();
    return node.data;
  }
  int remove(int index){
    if(index >= length){
      System.out.println("Invalid Operation");
      return Integer.MIN_VALUE;
    }
    if(length  == 1){
      Node temp = last;
      last = null;
      length --;
      display();
      return temp.data;
    }
    else if(index == 0){
      Node head = last.next;
      last.next = head.next;
      length--;
      display();
      return head.data;
    }
    else if(index == length-1){
      return pop();
    }
    else{
      Node head = last.next;
      for(int i = 0; i<index-1; i++)
        head = head.next;
      Node temp = head.next;
      head.next = head.next.next;
      length--;
      display();
      return temp.data;
    }
  }

  public static void main(String[] args) {
    CircularLinkedList cLL = new CircularLinkedList();
    cLL.insert(1, 0);
    cLL.insert(3, 1);
    cLL.insert(2, 1);
    cLL.insert(0, 0);
    System.out.println(cLL.count());
    cLL.remove(3);
    cLL.remove(1);
    cLL.remove(0);
  }
}

class Node{
  Node next;
  int data;
  Node(int data){
    next = null;
    this.data = data;
  }
}
