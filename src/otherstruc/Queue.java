package otherstruc;

public class Queue {
    int[] array;
    int head;
    int tail;
    int length;

    public Queue(int length) {
        this.length = length;
        this.array = new int[length];
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        array[tail] = data;
        tail = (tail + 1) % array.length;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("队列已空，不可再出");
            return;
        }
        head = (head + 1) % array.length;
    }

    public int peek() {
        return array[head];
    }

    public int size() {
        return (tail + length - head) % length - 1;
    }

    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((tail + 1) % array.length == head) {
            return true;
        }
        return false;
    }


}
