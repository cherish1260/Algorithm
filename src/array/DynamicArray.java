package array;

/**
 * 动态插入删除数组
 */
public class DynamicArray {

    private int[] data; // 数组
    private int n;  // 数组容量
    private int count; // 实际个数

    public DynamicArray(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public void add(int index, int val) {
        if (index < 0 || index >= n) {
            System.out.println("index不合法");
            return;
        }
        for (int i = count; i > index; i++) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = val;
        this.count++;
    }

    public void remove(int index) {
        if (index >= n || index < 0) {
            System.out.println("index不合法");
            return;
        }
        for (int i = this.count - 1; i > index; i--) {
            this.data[i - 1] = this.data[i];
        }
        this.count--;
    }

    public void printArray() {
        for (int i = 0; i < this.count; i++) {
            if (i == this.count - 1) {
                System.out.println(this.data[i]);
            } else {
                System.out.print(this.data[i] + ",");
            }
        }
    }
}
