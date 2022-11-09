public class StackOnListApp {
    public static void main(String[] args) {
        StackOnList myStack = new StackOnList();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.displayList();
        myStack.pop().displayLink();
        myStack.pop().displayLink();
        myStack.pop().displayLink();
    }
}


class StackOnList {
    private Item first;


    public void push(int key) {
        Item newItem = new Item(key);
        newItem.next = first;
        first = newItem;
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