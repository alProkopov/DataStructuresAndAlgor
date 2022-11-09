public class DoubleListApp {
    public static void main(String[] args) {
        DoubleList myList = new DoubleList();

        myList.insertLast(4);

        myList.displayList();


    }
}

class DoubleLink {
    int data;
    DoubleLink prev;
    DoubleLink next;

    DoubleLink(int data) {
        this.data = data;
    }

    public void displayLink() {
        System.out.print("{int: " + data + "} ");
    }
}


class DoubleList {
    DoubleLink first;
    DoubleLink last;

    public void insertFirst(int data) {
        DoubleLink newItem = new DoubleLink(data);
        if (isEmpty()) {
            last = newItem;
        } else {
            first.prev = newItem;
        }
        newItem.next = first;
        first = newItem;
    }


    public void insertLast(int data){
        DoubleLink newItem = new DoubleLink(data);
        if (isEmpty()){
            first = newItem;
        } else{
            last.next = newItem;

        }
        newItem.prev = last;
        last = newItem;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        DoubleLink current = this.first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
