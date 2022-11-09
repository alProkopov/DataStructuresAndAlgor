public class LastLinkListApp {
    public static void main(String[] args) {
        LastLinkList myList = new LastLinkList();

        myList.sortInsert(5);
        myList.sortInsert(6);
        myList.sortInsert(7);
        myList.sortInsert(8);
        myList.sortInsert(4);
        myList.sortInsert(3);
        myList.sortInsert(2);
        myList.sortInsert(1);
        myList.displayList();

    }
}

class Item{
    int data;
    Item next;

    Item(int data){
        this.data = data;

    }
    public void displayLink() {
        System.out.print("{int: " + data + "} ");
    }

}

class LastLinkList{
    private Item first;
    private Item last;

    public boolean isEmpty(){
        return first==null;
    }

    public void insertFirst(int data){
        Item item = new Item(data);
        if (isEmpty()){
            last = item;
        }
        item.next = first;
        first = item;
    }

    public void sortInsert(int data){
        Item prev = null;
        Item current = first;
        Item newItem = new Item(data);

        while (current != null && data > current.data){
            prev = current;
            current = current.next;
        }
        if (prev == null){
            first = newItem;
        } else{
            prev.next = newItem;
        }
        newItem.next = current;

    }

    public void insertLast(int data){
        Item item = new Item(data);
        if (isEmpty()){
            last = item;
            first = item;
        } else{
            last.next = item;
            last = item;
        }
    }

    public Item deleteFirst(){
        Item tmp = this.first;
        this.first = first.next;
        return tmp;
    }

    public void displayList(){
        Item current = this.first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }


}
