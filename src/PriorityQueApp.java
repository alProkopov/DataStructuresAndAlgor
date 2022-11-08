public class PriorityQueApp {
    public static void main(String[] args) {

        PriorityQue myQ = new PriorityQue(5);
        myQ.insert(1);
        myQ.insert(2);
        myQ.insert(1);
        myQ.insert(5);
        myQ.insert(4);
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());
        System.out.println(myQ.remove());




    }
}

class PriorityQue {
    private int maxSize;
    private int[] a;
    private int len;

    PriorityQue(int size) {
        maxSize = size;
        a = new int[maxSize];
        len = 0;
    }

    public int remove() {
        return a[--len];
    }

    public void insert(int key) {
        if (len == 0) {
            a[len++] = key;
        } else {
            int k = len - 1;
            while (k >= 0 && key >= a[k]) {
                a[k + 1] = a[k];
                k--;
            }
            a[k + 1] = key;
            len++;
        }
    }

    public int size() {
        return this.len;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == maxSize;
    }
}
