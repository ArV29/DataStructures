public class BinarySearchTree {
  Node root;
  BinarySearchTree(){
    root = null;
  }
  
  void bfs() {
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

  void inOrder() {
    System.out.print("inOrder traversal of the tree:\t\t");
    inOrderTraversal(root);
    System.out.println();
  }

  void inOrderTraversal(Node root) {
    if (root == null) {
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

  int height() {
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

  
  void insert(int data, Node node){
    if(this.root == null){
      this.root = new Node(data);
      return;
    }
    if(node.data <   data){
      if(node.right != null)
        insert(data, node.right);
      else
        node.right = new Node(data);
    } else{
      if(node.left != null)
        insert(data, node.left);
      else
        node.left = new Node(data);
    }
  }
  
  Node remove(int key, Node root) {
    if (root == null)
      return root;
    if (key < root.data)
      root.left = remove(key, root.left);
    else if (key > root.data)
      root.right = remove(key, root.right);

    else {
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;

      root.data = successor(root.right);

      root.right = remove(root.data, root.right);
    }
    return root;
  }
  
  int successor(Node root) {
    int min = root.data;
    while (root.left != null) {
      min = root.left.data;
      root = root.left;
    }
    return min;
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(5, bst.root);
    bst.insert(4, bst.root);
    bst.insert(6, bst.root);
    bst.insert(9, bst.root);
    bst.insert(0, bst.root);
    bst.insert(8, bst.root);
    bst.inOrder();
    bst.remove(5,bst.root );
    bst.inOrder();

  }
  

}

class Node{
  Node left, right;
  int data;
  Node(int data){
    this.data = data;
    left = right = null;
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
