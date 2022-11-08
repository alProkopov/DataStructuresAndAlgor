public class QueueApp {
    public static void main(String[] args) {
        Queue myQue = new Queue(4);
        myQue.insert(1);
        System.out.println(myQue.len);
        myQue.insert(2);
        myQue.insert(3);
        myQue.insert(4);
        System.out.println(myQue.len);
        System.out.println(myQue.remove());
        myQue.insert(5);
        System.out.println(myQue.remove());
        System.out.println(myQue.remove());
        System.out.println(myQue.remove());
        System.out.println(myQue.remove());
        System.out.println(myQue.remove());
        System.out.println(myQue.remove());
    }
}

class Queue {
    int start;
    int end;
    int len;
    int[] a;
    int maxSize;

    Queue(int size) {
        a = new int[size];
        maxSize = size;
        start = 0;
        end = -1;
        len = 0;
    }

    public void insert(int key) {
        if (isFull()) {
            System.out.println("full");
            return;
        }
        end = (end+1)%maxSize;
        len++;
        a[end] = key;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("empty");
            System.exit(-1);
        }
        int tmp = a[start];
        start = (start + 1)%maxSize;
        len--;
        return tmp;

    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return len == maxSize;
    }
}