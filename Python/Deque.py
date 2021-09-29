class Deque:

  def __init__(self, n):
    self.deque = [0]*n
    self.front = n+1
    self.rear = 0
    self.maxSize = n
    self.currentSize = 0

  
  def isFull(self):
    return self.currentSize == self.maxSize
  
  def isEmpty(self):
    return self.currentSize  == 0

  
  def addFront(self, data):
    if self.isFull():
      print("OPERATION FAILED, DEQUE FULL")
      return
    
    self.front = (self.front - 1)%self.maxSize
    self.deque[self.front] = data
    self.currentSize +=1
  
  def addRear(self, data):
    if self.isFull():
      print("OPERATION FAILED, DEQUE FULL")
      return
    
    self.rear = (self.rear + 1)%self.maxSize
    self.deque[self.rear] = data
    self.currentSize+=1
  
  def removeRear(self):
    if self.isEmpty():
      print("OPERATION FAILED, DEQUE EMPTY")
      return
    data = self.deque[self.rear]
    self.deque[self.rear] = 0
    self.rear = (self.rear - 1) % self.maxSize
    self.currentSize -=1
    return data

  def removeFront(self):
    if self.isEmpty():
      print("OPERATION FAILED, DEQUE EMPTY")
      return

    data = self.deque[self.front]
    self.deque[self.front] = 0
    self.front = (self.front + 1) % self.maxSize
    self.currentSize -=1
    return data

  def peekFront(self):
    if self.isEmpty():
      print("OPERATION FAILED, DEQUE EMPTY")
      return
    
    return self.deque[self.front]

  def peekRear(self):
    if self.isEmpty():
      print("OPERATION FAILED, DEQUE EMPTY")
      return

    return self.deque[self.rear]





def main():
  dq = Deque(3)
  print('Insert Element at front')
  print("Insert element at rear end  : 5 ")
  dq.addRear(5)
  print("Insert element at rear end : 10 ")
  dq.addRear(10)
  print(f"Get rear element : {dq.peekRear()}")
  dq.removeRear()
  print(f"After delete rear element new rear become : {dq.peekRear()}")
  print("Inserting element at front end")
  dq.addFront(15)
  print(f"Get front element: {dq.peekFront()}")
  dq.removeFront()
  print(f"After delete front element new front become : {dq.peekFront()}")




  
main()