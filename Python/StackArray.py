class StackArray:

	def __init__(self, length):
		self.MAX = length
		self.stack = self.MAX*[0]
		self.top = -1

	def isFull(self):
		return self.top == self.MAX-1

	def isEmpty(self):
		return self.top == -1

	def push(self, data):
		if self.isFull():
			print("ERROR: Stack Overflow")
			return -1

		self.top += 1
		self.stack[self.top] = data
		print(data, "pushed to stack")

	def pop(self):
		if self.isEmpty():
			print("ERROR: Stack Underflow")
			return -1*self.MAX

		data = self.stack[self.top]
		self.top -= 1
		print(data, "popped from stack")
		return data

	def peek(self):
		if self.isEmpty():
			print("ERROR: Stack Underflow")
			return -1*self.MAX

		return self.stack[self.top]

	def print(self):
		if self.isEmpty():
			print("ERROR: Stack Underflow")
			return -1*self.MAX

		print("Stack Has the following elements:\n", self.stack[0:self.top+1])


def main():

	stack1 = StackArray(100000)

	print("Is the stack empty?\t", stack1.isEmpty())
	stack1.push(10)
	stack1.push(20)
	stack1.pop()
	print("Topmost element: ", stack1.peek())
	print("Is the stack Full?\t", stack1.isFull())
	stack1.pop()
	print("Is the stack empty?\t", stack1.isEmpty())
	print("Topmost element: " + (stack1.peek if stack1.peek() != -stack1.MAX else "NA"))


main()
