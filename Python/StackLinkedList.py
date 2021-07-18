class StackLinkedList:


    def __init__(self):
        self.top = None;


    def isEmpty(self):
        return self.top == None

    def push(self, data):
        temp = self.top
        self.top = StackNode(data)
        self.top.next = temp
        print(str(data) + " pushed to the top of the stack")


    def pop(self):
        if(self.isEmpty()):
            print("Stack Underflow");
            return float("-inf")
        
        data = self.top.data
        self.top = self.top.next
        return data
    

    def peek(self):
        if(self.isEmpty()):
            print("Stack Underflow");
            return float("-inf")
        return self.top.data
               




class StackNode:

    def __init__(self, data):
        self.next = None;
        self.data = data;
