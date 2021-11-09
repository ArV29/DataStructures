def bfs(root):
  queue = Queue(10)
  queue.add(root)
  while(not queue.isEmpty()):
    current = queue.pop()
    print(current.data, end = " ")
    if(current.left != None):
      queue.add(current.left)
    if(current.right != None):
     queue.add(current.right)
  print()
  
   
def inOrder(root):
  if root == None:
    return
  inOrder(root.left)
  print(root.data, end = " ")
  inOrder(root.right)


def preOrder(root):
  if root == None:
    return
  print(root.data, end=" ")
  preOrder(root.left)
  preOrder(root.right)


def postOrder(root):
  if root == None:
    return
  postOrder(root.left)
  postOrder(root.right)
  print(root.data, end=" ")




class Node:
  def __init__(self, data):
    self.data = data
    self.left = None
    self.right = None
  

class Queue:

  def __init__(self, n):
    self.MAX_SIZE = n
    self.queue = [0]*n
    self.rear = -1
    self.front = 0

  def isFull(self):
    return self.rear == self.MAX_SIZE-1

  def isEmpty(self):
    return (self.front-1 == self.rear and not self.isFull())

  def add(self, data):
    if self.isFull():
      return

    self.rear += 1
    self.queue[self.rear] = data

  def pop(self):
    if self.isEmpty():
      return -self.MAX_SIZE
    data = self.queue[self.front]

    self.front += 1
    return data



def main():


  root = Node(1)
  root.left = Node(2)
  root.right = Node(3)
  root.left.left = Node(4)
  root.left.right = Node(5)
  root.right.left = Node(6)
  root.right.right = Node(7)

  bfs(root)
  inOrder(root)
  print()
  preOrder(root)
  print()
  postOrder(root)
  print()



main()
