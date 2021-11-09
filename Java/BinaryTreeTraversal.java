public class BinaryTreeTraversal {
  Node root;

  BinaryTreeTraversal() {
    root = null;
  }

  int height(){
    return maxDepth(root);
  }
  
  int maxDepth(Node node) {
    if (node == null)
      return -1;
    else {
      int lDepth = maxDepth(node.left);
      int rDepth = maxDepth(node.right);
      if (lDepth > rDepth)
        return (lDepth + 1);
      else
        return (rDepth + 1);
    }
  }

  void printWhiteSpace(int n){
    for(int i = 0; i<n; i++){
      System.out.print(" ");
    }
  }
  void print(){
    int h = height();
    if(h==-1){
      return;
    }
    int[] val = new int[100];
    int index = 1;
    Queue q = new Queue(100);
    q.add(root);
    while (!q.isEmpty()) {
      Node current = q.pop();
      val[index++] = current.data;
      if (current.left != null) {
        q.add(current.left);
      }
      if (current.right != null) {
        q.add(current.right);
      }
    }
    String[] arrows = {"/", "\\"};
    printWhiteSpace((int) Math.pow(2, h) - 1);
    System.out.println(val[1]);
    for (int i = 1; i <= h; i++) {
      printWhiteSpace((int)Math.pow(2, h-i)-1);
      for (int ii = (int) Math.pow(2, i); ii < (int) Math.pow(2, i + 1); ii++) {
        if(ii==index)
          break;
        System.out.print(arrows[ii%2]);
        printWhiteSpace((int) Math.pow(2, h - i+1)-1 );
      }
      System.out.println();

      printWhiteSpace((int)Math.pow(2, h-i)-1);
      for (int ii = (int) Math.pow(2, i); ii < (int) Math.pow(2, i + 1); ii++) {
        if(ii==index)
          break;
        System.out.print(val[ii]);
        printWhiteSpace((int) Math.pow(2, h - i+1)-1);

      }
      System.out.println();
    }
  }
  
  
  void bfs(){
    System.out.print("Breadth first traversal of the tree:\t");
    bfsTraversal();
    System.out.println();

  }
  void bfsTraversal() {
    Queue q = new Queue(100);
    q.add(root);
    while (!q.isEmpty()) {
      Node current = q.pop();
      System.out.print(current.data + " ");
      if (current.left != null) {
        q.add(current.left);
      }
      if (current.right != null) {
        q.add(current.right);
      }
    }
  }


  void inOrder(){
    System.out.print("inOrder traversal of the tree:\t\t");
    inOrderTraversal(root);
    System.out.println();
  }

  void inOrderTraversal(Node root){
    if(root == null){
      return;
    }
    inOrderTraversal(root.left);
    System.out.print(root.data + " ");
    inOrderTraversal(root.right);
  }

  void preOrder() {
    System.out.print("preOrder traversal of the tree:\t\t");
    preOrderTraversal(root);
    System.out.println();
  }

  void preOrderTraversal(Node root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrderTraversal(root.left);    
    preOrderTraversal(root.right);
  }

  void postOrder() {
    System.out.print("postOrder traversal of the tree:\t");
    postOrderTraversal(root);
    System.out.println();
  }

  void postOrderTraversal(Node root) {
    if (root == null) {
      return;
    }
    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    System.out.print(root.data + " ");

  }

  void insert(int data) {
    if (root == null) {
      root = new Node(data);
      return;
    }
    Queue q = new Queue(100);
    q.add(root);
    while (!q.isEmpty()) {
      Node current = q.pop();
      if (current.left != null) {
        q.add(current.left);
      } else {
        current.left = new Node(data);
        break;
      }
      if (current.right != null) {
        q.add(current.right);
      } else {
        current.right = new Node(data);
        break;
      }
    }
  }

  public static void main(String[] args) {
    BinaryTreeTraversal bt = new BinaryTreeTraversal();
    for (int i = 1; i < 8; i++) {
      bt.insert(i);
    }
    
    System.out.println("GIVEN BINARY TREE:");
    bt.print();
    bt.bfs();
    bt.inOrder();
    bt.preOrder();
    bt.postOrder();

  }

}

class Node {
  Node left, right;
  int data;

  Node(int data) {
    left = right = null;
    this.data = data;
  }
}

class Queue {
  private Node[] queue;
  private int rear, front;
  final int MAX_SIZE;

  Queue(int n) {
    MAX_SIZE = n;
    queue = new Node[n];
    rear = -1;
    front = 0;
  }

  boolean isFull() {
    return (rear == MAX_SIZE - 1);
  }

  boolean isEmpty() {
    return (front - 1 == rear && !isFull());
  }

  void add(Node node) {
    if (isFull()) {
      return;
    }
    queue[++rear] = node;
  }

  Node pop() {
    if (isEmpty()) {
      return null;
    }
    Node node = queue[front];
    front++;
    return node;
  }
}