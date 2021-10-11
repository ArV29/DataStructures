class Stack:

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

	def pop(self):
		if self.isEmpty():
			print("ERROR: Stack Underflow")
			return -1*self.MAX

		data = self.stack[self.top]
		self.top -= 1
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

