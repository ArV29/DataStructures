class CircularQueueArray:

  def __init__(self, n):
    self.MAX_SIZE = n
    self.queue = [0]*n
    self.rear = -1
    self.front = 0
    self.currentSize = 0

  def isFull(self):
    return self.currentSize == self.MAX_SIZE

  def isEmpty(self):
    return self.currentSize == 0

  def enqueue(self, data):
    if self.isFull():
      print("Enqueue Process Failed.\nQueue is at Maximum Capacity!")
      return
    print(data, " added to the back of the queue")

    self.rear = (self.rear+1)%self.MAX_SIZE
    self.queue[self.rear] = data
    self.currentSize+=1

  def dequeue(self):
    if self.isEmpty():
      print("Dequeue Process Failed.\nQueue is Empty!")
      return -self.MAX_SIZE
    data = self.queue[self.front]
    print(data, " removed from the front of the queue")

    self.front = (self.front+1)%self.MAX_SIZE
    self.currentSize-=1
    return data

  def frontElement(self):
    if self.isEmpty():
      print("Unable to get data.\nQueue is Empty!")
      return -self.MAX_SIZE
    return self.queue[self.front]

  def rearElement(self):
    if self.isEmpty():
      print("Unable to get data.\nQueue is Empty!")
      return -self.MAX_SIZE
    return self.queue[self.rear]


def main():
  queue = CircularQueueArray(3)
  print("Is the queue empty?\t", queue.isEmpty())
  queue.dequeue()
  queue.enqueue(10)
  queue.enqueue(20)
  queue.enqueue(40)
  print("Element at the front of the queue: ", queue.frontElement())
  print("Element at the rear of the queue: ", queue.rearElement())
  print("Is the queue full?\t", queue.isFull())
  queue.enqueue(80)
  queue.dequeue()
  queue.enqueue(80)
  print("Is the queue full?\t", queue.isFull())
  print("Is the queue empty?\t", queue.isEmpty())


main()
