class Deque {
	int[] deque;
	int rear, front, currentSize, maxSize;

	Deque(int n) {
		deque = new int[n];
		rear = 0;
		front = n + 1;
		maxSize = n;
		currentSize = 0;
	}

	boolean isFull() {
		return (currentSize == maxSize);
	}

	boolean isEmpty() {
		return (currentSize == 0);
	}

	void addFront(int data) {
		if (isFull()) {
			System.out.println("Operation Failed, DEQUE FULL");
			return;
		}
		front = (front - 1) % maxSize;
		front = (front == -1) ? maxSize - 1 : front;
		deque[front] = data;
		currentSize++;
	}

	void addRear(int data) {
		if (isFull()) {
			System.out.println("Operation Failed, DEQUE FULL");
			return;
		}
		rear = (rear + 1) % maxSize;
		deque[rear] = data;
		currentSize++;
	}

	int removeFront() {
		if (isEmpty()) {
			System.out.println("Operation Failed, DEQUE EMPTY");
			return (-maxSize - 1);
		}
		int data = deque[front];
		deque[front] = 0;
		front = (front + 1) % maxSize;
		currentSize--;
		return data;

	}

	int removeRear() {
		if (isEmpty()) {
			System.out.println("Operation Failed, DEQUE EMPTY");
			return (-maxSize - 1);
		}
		int data = deque[rear];
		deque[rear] = 0;
		rear = (rear - 1) % maxSize;
		rear = (rear == -1) ? maxSize - 1 : rear;

		currentSize--;
		return data;

	}

	int peekFront() {
		if (isEmpty()) {
			System.out.println("Operation Failed, DEQUEUE EMPTY");
			return (-maxSize - 1);
		}
		return deque[front];
	}

	int peekRear() {
		if (isEmpty()) {
			System.out.println("Operation Failed, DEQUEUE EMPTY");
			return (-maxSize - 1);
		}
		return deque[rear];
	}

	void print() {
		for (int i = 0; i < maxSize; i++) {
			System.out.print(deque[i] + " ");
		}
		System.out.println("\nFront: " + front + "\tRear: " + rear);
	}

	public static void main(String[] args) {
		Deque dq = new Deque(3);
		System.out.println("Insert element at rear end  : 5 ");
		dq.addRear(5);
		System.out.println("Insert element at rear end : 10 ");
		dq.addRear(10);
		System.out.println("Get rear element : " + dq.peekRear());
		dq.removeRear();
		System.out.println("After delete rear element new rear become : " + dq.peekRear());
		System.out.println("inserting element at front end");
		dq.addFront(15);
		System.out.println("get front element: " + dq.peekFront());
		dq.removeFront();
		System.out.println("After delete front element new front become : " + +dq.peekFront());
	}

}
