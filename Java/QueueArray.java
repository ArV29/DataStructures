package Java;
class QueueArray{
  private int[] queue;
  private int rear, front;
  final int MAX_SIZE;
  QueueArray(int n){
    MAX_SIZE = n;
    queue = new int[n];
    rear =-1;
    front = 0;
  }

  boolean isFull(){
    return (rear == MAX_SIZE-1);
  }
  boolean isEmpty(){
    return (front-1 == rear && !isFull());
  }
  void enqueue(int data){
    if(isFull()){
      System.out.println("Enqueue Process Failed.\nQueue is at Maximum Capacity!");
      return;
    }
    System.out.println(data+ " added to the back of the queue");
    queue[++rear] = data;
  }
  int dequeue(){
    if (isEmpty()) {
      System.out.println("Dequeue Process Failed.\nQueue is Empty!");
      return -MAX_SIZE;
    }
    int data = queue[front];
    System.out.println(data+" removed from the front of the queue");
    front++;
    return data;
  }
  int front(){
    if (isEmpty()) {
      System.out.println("Unable to get data.\nQueue is Empty!");
      return -MAX_SIZE;
    }
    return queue[front];
  }
  int rear(){
    if (isEmpty()) {
      System.out.println("Unable to get data.\nQueue is Empty!");
      return -MAX_SIZE;
    }
    return queue[rear];
  }

  public static void main(String[] args) {
    QueueArray queue = new QueueArray(3);
    System.out.println("Is the queue empty?\t" + queue.isEmpty());
    queue.dequeue();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(40);
    System.out.println("Element at the front of the queue: "+queue.front());
    System.out.println("Element at the rear of the queue: " + queue.rear());
    System.out.println("Is the queue full?\t" + queue.isFull());
    queue.enqueue(80);
    queue.dequeue();
    System.out.println("Is the queue full?\t" + queue.isFull());
    System.out.println("Is the queue empty?\t" + queue.isEmpty());
     
  }
}