public class BST<T extends Comparable<T>> {
    Node<T> root;

    public void insert(T value) {
        root = insertRec(value, root);
    }

    public Node<T> getRoot(){
        return this.root;
    }

    public T contains(T value, Node<T> root){
        return containsRec(value, root);
    }

    private Node<T> insertRec(T value, Node<T> root) {
        if (root == null) {
            return new Node<T>(value);
        }

        if (value.compareTo(root.value) < 0) {
            root.left = insertRec(value, root.left);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertRec(value, root.right);
        } else {
            System.out.println("Valor duplicado");
        }

        return root;
    }

    private T containsRec (T value, Node<T> root){
        if (root == null) {
            return null;
        }

        if (value.compareTo(root.value) == 0){
            return root.value;
        } else if (value.compareTo(root.value) < 0) {
            return containsRec(value, root.left);
        } else if (value.compareTo(root.value) > 0) {
            return containsRec(value, root.right);
        }

        return null;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<T> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.value + " ");
            inOrderRec(node.right);
        }
    }
}