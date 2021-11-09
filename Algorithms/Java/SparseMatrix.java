class SparseMatrix {
  static LinkedList matrix2Sparse(int[][] matrix){
    LinkedList result = new LinkedList();
    for(int i = 0; i<matrix.length; i++){
      for(int j = 0; j<matrix[i].length; j++){
        if(matrix[i][j] != 0){
          result.append(i, j, matrix[i][j]);
        }
      }
    }
    return result;
  }
  public static void main(String[] args) {
    int[][] matrix = {{  0,  0,  0,  1,  2, 3 },
                      {  4,  5,  6,  0,  0, 0 },
                      {  7,  0,  8,  0,  9, 0 },
                      {  0, 10,  0, 11,  0, 12 },
                      {  0,  0, 13, 14,  0, 0 },
                      {  0, 15,  0,  0, 16, 0 },
                      { 17,  0,  0,  0,  0, 18 }};

    LinkedList result = SparseMatrix.matrix2Sparse(matrix);

    System.out.println("Given Matrix:");
    for(int i = 0; i<matrix.length; i++){
      for(int j = 0; j<matrix[i].length; j++){
        System.out.print(matrix[i][j]+"\t");
      }
      System.out.println();
    }

    System.out.println("After Conversion to Sparse Matrix: ");
    result.print();

  }
  
}

class LinkedList {
  Node head;
  int length;

  // Functions regarding accessing the value of the linked list

  // Print the whole list
  void print() {
    Node r =  this.head;
    Node c = this.head;
    Node v = this.head;
    System.out.print("Row Position:\t\t");
    while(r!=null){
      System.out.print(r.row+"\t");
      r = r.next;
    }
    System.out.println();

    System.out.print("Column Position:\t");
    while (c != null) {
      System.out.print(c.column + "\t");
      c = c.next;
    }
    System.out.println();

    System.out.print("Value:\t\t\t");
    while (v != null) {
      System.out.print(v.value + "\t");
      v = v.next;
    }
    System.out.println();
    
  }
  // Functions Regarding Addition Of A Node

  void append(int row, int column, int value) {
    if (head == null) {
      head = new Node(row, column, value);
      return;
    }
    Node current = this.head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new Node(row, column, value);
    this.length++;
  }

  void push(int row, int column, int value) {
    Node newNode = new Node(row, column, value);
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
  int row, column, value;

  Node(int row, int column, int value) {
    this.row = row;
    this.column = column;
    this.value = value;
    next = null;
  }

}
