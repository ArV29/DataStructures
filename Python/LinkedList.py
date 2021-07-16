class Node:

    def __init__(self, data) :
        self.data  = data
        self.next = None

class LinkedList:

    def __init__(self):
        self.head = None
        self.length = 0
    #Functions regarding accesing the value of the linked list

        #Print the whole list
    def print(self):
        head = self.head
        while head!= None:
            print(str(head.data) + " -> ", end = "")
            head = head.next
        print("END")

        #Get the Node at the specified index
    def NodeAtIndex(self, index):
        if index > self.length or index < 0:
            print('Unable to get None. IndexOutOfBounds')
        i = 0
        head = self.head
        while i < index:
            head = head.next
            i+=1
        return head.next
    
    
    
    #Functions Regarding Addition Of A Node

        #Add a node to the back of the list
    def append(self, data):
        if self.head == None:
            self.head = Node(data)
        else:
            head = self.head
            while head.next!=None:
                head = head.next
            head.next = Node(data)
        self.length +=1 
    

        #Add a node to the front of the list
    def push(self, data):
        head = self.head
        self.head = Node(data)
        self.head.next = head
        self.length += 1

    
        #Add a node at the specified  index in the list (used 0 based indexing)
    def insertAtIndex(self, index, data):
        if index>self.length or index<0:
            print('Unable to add Node. IndexOutOfBounds')
        i = 0
        head = self.head
        
        while i<index:
            head = head.next
            i+=1
        if head.next:
            temp = head.next.next
        else:
            temp = None
        head.next = Node(data)
        head.next.next = temp
        self.length += 1



    #Functions Regarding Removal of A Node

        #Remove the last node from the list and returns it
    def pop(self):
        head = self.head
        while head.next!=None:
               head = head.next
        lastNode = head.next
        head.next = None
        self.length -= 1

        return lastNode
    
        #Remove the Node at the specified index (default value = 0)
    def removeAtIndex(self, index = 0):
        if index > self.length or index < 0:
            print('Unable to remove Node. IndexOutOfBounds')
            return 0

        i = 0
        head = self.head
        
        if index ==0 :
            self.head = head.next
            return


        while i < index-1:
            head = head.next
            i+=1

        head.next = head.next.next
        self.length -= 1


#driver function
if __name__ == '__main__':

    ll = LinkedList()
    ll.append(1)
    ll.append(4)
    ll.append(1)
    ll.append(12)
    ll.removeAtIndex(0)
    ll.print()
