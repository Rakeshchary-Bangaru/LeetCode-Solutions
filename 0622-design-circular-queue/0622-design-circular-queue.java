class MyCircularQueue {
     int[] list;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        list = new int[k];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {

        // Queue full
        if (isFull()) {
            return false;
        }

        // First element
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % list.length;
        }

        list[rear] = value;

        return true;
    }

    public boolean deQueue() {

        // Queue empty
        if (isEmpty()) {
            return false;
        }

        // Only one element
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % list.length;
        }

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return list[front];
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return list[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {

        if (isEmpty()) {
            return false;
        }

        return front == (rear + 1) % list.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */