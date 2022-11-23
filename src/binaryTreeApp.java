public class binaryTreeApp {
    public static void main(String[] args) {
        Tree myTree = new Tree();
        myTree.insert(38);
        myTree.insert(26);
        myTree.insert(72);
        myTree.insert(55);
        myTree.insert(90);
        myTree.insert(41);
        myTree.insert(69);
        myTree.insert(78);
        myTree.insert(92);

        myTree.remove(72);
        System.out.println(myTree.root.right.right.right.data);

//        myTree.inOrder(myTree.root);

    }
}


class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}


class Tree {
    Node root;

    public Node find(int key) {
        Node current = root;
        while (current.data != key) {
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        return current;

    }

    public void insert(int key) {
        Node newNode = new Node(key);
        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node current = this.root;
        Node parent = null;

        while (current != null) {
            parent = current;
            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }

        }

        if (key < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }


    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.println(localRoot.data);
            inOrder(localRoot.right);
        }
    }

    public Node remove(int key) {
//        Node delItem = find(key);
        //find item
        Node current = root;
        Node parent = null;
        boolean isLeft = true;

        while (current.data != key) {
            parent = current;

            if (key < current.data) {
                current = current.left;
                isLeft = true;
            } else {
                current = current.right;
                isLeft = false;
            }

            if (current == null) {
                return null;
            }

        }

        //has not children
        if (current.left == null && current.right == null) {
            if (current == root) {
                current = null;
            } else if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }

            //1 child
        } else if (current.left == null) {
            if (current == root) {
                root = current.right;
            } else if (isLeft) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }

        } else if (current.right == null) {
            if (current == root) {
                root = current.left;
            } else if (isLeft) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else {
            System.out.println("hello");
            //2 child. need successor
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeft) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }

        }
        return current;


    }

    public Node getSuccessor(Node delNode) {
        Node current = delNode.right;
        Node parent = null;
        Node successor = delNode;

        while (current != null) {
            parent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != delNode.right) {
            parent.left = successor.right;
            successor.right = delNode.right;
            successor.left = delNode.left;
        }

        return successor;
    }
}