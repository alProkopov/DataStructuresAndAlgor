public class ListApp {
    public static void main(String[] args) {
        LinkList myList = new LinkList();
        myList.insertFirst(3, "fucker");
        myList.insertFirst(2, "mother");
        myList.insertFirst(1, "hello");

        myList.delete(1);
        myList.displayList();


    }

}

class Link {
    public int i;
    public String s;
    public Link next;

    Link(int i, String s) {
        this.i = i;
        this.s = s;
    }

    Link(int i) {
        this.i = i;

    }

    public int getKey(){
        return this.i;
    }

    public void displayLink() {
        System.out.print("{String: " + s + ", int: " + i + "} ");
    }
}

class LinkList {
    private Link first;

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int i, String s) {
        Link link = new Link(i, s);
        link.next = first;
        this.first = link;

    }

    public void insertFirst(int i) {
        Link link = new Link(i);
        link.next = first;
        this.first = link;

    }

    public Link deleteFirst(){
        Link tmp = this.first;
        this.first = first.next;
        return tmp;
    }

    public void displayList(){
        Link current = this.first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public Link find (int key){
        Link current = first;
        while (current.i != key){
            if (current == null){
                return null;
            }
            current = current.next;
        }
        return current;
    }

    public Link delete(int key){
        Link prev = first;
        Link current = first;

        while (current.i != key){
            if (current == null){
                return null;
            }
            prev = current;
            current = current.next;
        }
        if (current == first){
            first = first.next;
        } else{
            prev.next = current.next;

        }
        return current;

    }

}