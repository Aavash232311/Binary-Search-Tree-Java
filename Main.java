class Main {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static boolean searchTree(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data > data) {
            return searchTree(root.left, data);
        } else if (root.data == data) {
            return true;
        } else {
            return searchTree(root.right, data);
        }
    }

    public static Node deleteNode (Node root, int val){
        if (root.data > val){
            root.left = deleteNode(root.left, val);
        }else if (root.data == val){
            // case 1 where both left and right is null
            if (root.left == null && root.right == null){
                return null;
            }
            // case 2 either left or right one is not null

            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }

            // case 2 has 2 children

            Node Is = inorderSuccess(root.right);
            root.data = Is.data;
            root.right = deleteNode(root.right, Is.data);

        }else{
            root.right = deleteNode(root.right, val);
        }
        return root;
    }

    public static Node inorderSuccess(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {5, 3, 4, 2, 7};
        int i;
        Node root = null;
        for (i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println(" ");
        deleteNode(root, 5);
        inOrder(root);
    }
}