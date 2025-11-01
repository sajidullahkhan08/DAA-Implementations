class AVLNode {
    int value, height;
    AVLNode left, right;

    AVLNode(int value) {
        this.value = value;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLImplementation {
    private AVLNode root;
    public AVLImplementation() {
        this.root = null;
    }
    private int height(AVLNode node ) {
        if (node == null)
            return 0;
        return node.height;
    }
    private int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }
    private void updateHeight(AVLNode node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }
    public void insert(int value) {
        root = insert(root, value);
        System.out.println("Inserted " + value);
    }
    private AVLNode insert(AVLNode node, int value) {
        if (node == null) {
            return new AVLNode(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            return node; 
        }
        updateHeight(node);
        int balance = getBalance(node);

        if (balance > 1 && value < node.left.value) {
            System.out.println("Left Left Case, Right Rotation on " + node.value);
            return rightRotate(node);
        }
        if (balance < -1 && value > node.right.value) {
            System.out.println("Right Right Case, Left Rotation on " + node.value);
            return leftRotate(node);
        }
        if (balance > 1 && value > node.left.value) {
            System.out.println("Left Right Case, Left Rotation on " + node.left.value + " and Right Rotation on " + node.value);
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && value < node.right.value) {
            System.out.println("Right Left Case, Right Rotation on " + node.right.value + " and Left Rotation on " + node.value);
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public boolean search(int value) {
        return search(root, value);
    }
    private boolean search(AVLNode node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public void inOrder() {
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();
    }
    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }
    public void preOrder() {
        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.println();
    }
    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    public void postOrder() {
        System.out.print("Postorder Traversal: ");
        postorder(root);
        System.out.println();
    }
    private void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }
    public static void main(String[] args) {
        System.out.println("AVL Tree Demonstration:");

        System.out.println("Testing LL Case (Inserting 30, 20, 10):");
        AVLImplementation avlTree1 = new AVLImplementation();
        avlTree1.insert(30);
        avlTree1.insert(20);
        avlTree1.insert(10);

        avlTree1.inOrder();
        avlTree1.preOrder();
        avlTree1.postOrder();

        System.out.println("\nTesting RR Case (Inserting 10, 20, 30):");
        AVLImplementation avlTree2 = new AVLImplementation();
        avlTree2.insert(10);
        avlTree2.insert(20);
        avlTree2.insert(30);

        avlTree2.inOrder();
        avlTree2.preOrder();
        avlTree2.postOrder();

        System.out.println("\nTesting LR Case (Inserting 30, 10, 20):");
        AVLImplementation avlTree3 = new AVLImplementation();
        avlTree3.insert(30);
        avlTree3.insert(10);
        avlTree3.insert(20);

        avlTree3.inOrder();
        avlTree3.preOrder();
        avlTree3.postOrder();

        System.out.println("\nTesting RL Case (Inserting 10, 30, 20):");
        AVLImplementation avlTree4 = new AVLImplementation();
        avlTree4.insert(10);
        avlTree4.insert(30);
        avlTree4.insert(20);

        avlTree4.inOrder();
        avlTree4.preOrder();
        avlTree4.postOrder();

        System.out.println("Testing Search");
        System.out.println("Searching for 20: " + avlTree4.search(20));
        System.out.println("Searching for 40: " + avlTree4.search(40));
        System.out.println("AVL Tree Demonstration Completed.");


    }

}