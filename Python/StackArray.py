class StackArray:
    MAX = 100000000 #Just an arbitary limit
    def __init__(self) :
        self.stack = []
    
    def isEmpty(self):
        return len(self.stack) == 0
    
    def push(self,  data):
        if(len(self.stack) == self.MAX):
            print("Stack Overflow")
            return 0
        else:
            self.stack.append(data)
            return 1
    
    def pop(self):
        if(len(self.stack) == 0):
            print("Stack Underflow")
            return -self.MAX -1
        else:
            return self.stack.pop()
    
    def peep(self):
        if(len(self.stack) == 0):
            print("Stack Underflow")
            return -self.MAX - 1
        else:
            return self.stack[-1]


        
    
