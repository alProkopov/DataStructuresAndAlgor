public class LastLinkListApp {
    public static void main(String[] args) {
        LastLinkList myList = new LastLinkList();

        myList.insertLast(5);
        myList.insertLast(6);
        myList.insertLast(7);
        myList.insertLast(8);
        myList.insertFirst(4);
        myList.insertFirst(3);
        myList.insertFirst(2);
        myList.insertFirst(1);
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
