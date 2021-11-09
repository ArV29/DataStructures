class Node:

  def __init__(self, data):
    self.data = data
    self.next = None


class CircularLinkedList:
  
    def __init__(self):
        self.last = None
        self.length = 0

    def count(self):
        if self.last == None:
            return 0
        last = self.last
        count = 1
        while last.next != self.last:
            count+=1
            last = last.next
        return count
  
    def display(self):
        head = self.last.next
        while head != self.last:
            print(head.data, end=" ")
            head = head.next
        print(self.last.data)

    def __push(self, data):        
        node = Node(data)
        node.next = self.last.next
        self.last.next = node
        self.length +=1
        self.display()
    
    def __append(self, data):
        node = Node(data)
        node.next = self.last.next
        self.last.next = node
        self.last = node
        self.length+=1
        self.display()
    
    def insert(self, data, index=0):       
        if self.length == 0:
            node = Node(data)
            self.last = node
            self.last.next = node
            self.length += 1
            self.display()
        elif index == 0:
            self.__push(data)
        elif index == self.length:
            self.__append(data)
        else:
            head = self.last.next
            node = Node(data)
            i = 0            
            while i<index-1:
                head = head.next
                i+=1
            temp = head.next
            head.next = node
            node.next = temp
            self.length+=1
            self.display()
    
    def __pop(self):
        head = self.last.next
        while head.next != self.last:
            head = head.next        
        head.next = self.last.next
        node = self.last
        self.last = head
        self.length -=1
        self.display()
        return node.data
    
    def remove(self, index):
        if index >= self.length:
            print('Invalid Operation')
            return -1
        if self.length==1:
            temp = self.last
            self.last = None
            self.length-=1
            self.display()
            return temp.data
        if index == 0:
            head = self.last.next
            self.last.next = head.next
            self.length-=1
            self.display()
            return head.data      
        elif index == self.length - 1:
            return self.__pop()
        else: 
            i = 0
            head = self.last.next
            while i<index-1:
                head = head.next
                i+=1
            temp = head.next
            head.next = head.next.next
            self.length -=1
            self.display()
            return temp.data


def main():
    cLL = CircularLinkedList()
    cLL.insert(0)
    cLL.insert(3, index = 1)
    cLL.insert(1, index = 1)
    cLL.insert(2, index = 2)
    print(cLL.count())
    cLL.remove(3)
    cLL.remove(1)
    cLL.remove(0)
    


if __name__ == "__main__":
    main()
  
