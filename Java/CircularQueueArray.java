class CircularQueueArray {
  private int[] queue;
  private int rear, front, currentSize;
  private final int MAX_SIZE;
  CircularQueueArray(int n) {
    MAX_SIZE = n;
    queue = new int[n];
    rear = -1;
    front = currentSize = 0;
  }
  boolean isFull() {
    return (currentSize == MAX_SIZE);
  }
  boolean isEmpty() {
    return (currentSize == 0);
  }
  void enqueue(int data) {
    if (isFull()) {
      System.out.println("Enqueue Process Failed.\nQueue is at Maximum Capacity!");
      return;
    }
    System.out.println(data + " added to the back of the queue");

    rear = (rear + 1) % MAX_SIZE;
    queue[rear] = data;
    currentSize++;
  }
  int dequeue() {
    if (isEmpty()) {
      System.out.println("Dequeue Process Failed.\nQueue is Empty!");
      return -MAX_SIZE;
    }
    int data = queue[front];
    System.out.println(data + " removed from the front of the queue");

    front = (front + 1) % MAX_SIZE;
    currentSize--;
    return data;
  }
  int front() {
    if (isEmpty()) {
      System.out.println("Unable to get data.\nQueue is Empty!");
      return -MAX_SIZE;
    }
    return queue[front];
  }
  int rear() {
    if (isEmpty()) {
      System.out.println("Unable to get data.\nQueue is Empty!");
      return Integer.MIN_VALUE;
    }
    return queue[rear];
  }
  
  public static void main(String[] args) {
    CircularQueueArray queue = new CircularQueueArray(3);
    System.out.println("Is the queue empty?\t" + queue.isEmpty());
    queue.dequeue();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(40);
    System.out.println("Element at the front of the queue: " + queue.front());
    System.out.println("Element at the rear of the queue: " + queue.rear());
    System.out.println("Is the queue full?\t" + queue.isFull());
    queue.enqueue(80);
    queue.dequeue();
    queue.enqueue(80);
    System.out.println("Is the queue full?\t" + queue.isFull());
    System.out.println("Is the queue empty?\t" + queue.isEmpty());

  }
}