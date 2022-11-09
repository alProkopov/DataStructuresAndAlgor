public class QueueOnListApp {

    public static void main(String[] args) {

        QueueOnList myQ = new QueueOnList();
        myQ.push(1);
        myQ.push(2);
        myQ.push(3);
        myQ.push(4);

        myQ.pop().displayLink();
        System.out.println();
        myQ.pop().displayLink();
    }


}

class QueueOnList {
    private Item first;
    private Item last;

    public void push(int key) {
        Item newItem = new Item(key);
        if (isEmpty()) {
            first = newItem;
            last = newItem;
        }
        last.next = newItem;
        last = newItem;
    }

    public Item pop() {
        Item tmp = first;
        first = first.next;
        return tmp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        Item current = this.first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

}