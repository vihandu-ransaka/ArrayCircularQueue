class ArrayCircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor
    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = rear = size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Enqueue (Add an element)
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity; // Circular increment
        size++;
        System.out.println(value + " enqueued.");
    }

    // Dequeue (Remove an element)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println(value + " dequeued.");
        return value;
    }

    // Peek (Get the front element)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

// Main class to test the Circular Queue
public class CircularQueueTest {
    public static void main(String[] args) {
        ArrayCircularQueue queue = new ArrayCircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();

        queue.dequeue();
        queue.dequeue();
        queue.display();

        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();

        System.out.println("Front element: " + queue.peek());
    }
}
