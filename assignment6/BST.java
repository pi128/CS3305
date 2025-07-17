// Name: James Widner
// Class: CS3305/W01
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #6
// IDE Name: VSC



/**
 * Binary Search Tree (BST) implementation.
 * Supports generic data types and basic operations such as insert, delete, search, and traversals.
 */
public class BST<E> implements Tree<E> {

    protected TreeNode<E> root; // Root node of the BST
    protected int size = 0;     // Number of elements in the BST
    protected java.util.Comparator<E> c; // Comparator for custom element ordering

    /** Default constructor using natural ordering (Comparable). */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
    }

    /** Constructor using custom comparator. */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /** Constructor that inserts an array of elements. */
    public BST(E[] objects) {
        this();
        for (E e : objects)
            insert(e);
    }

    /** Search for an element in the BST. */
    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (c.compare(e, current.element) < 0)
                current = current.left;
            else if (c.compare(e, current.element) > 0)
                current = current.right;
            else
                return true;
        }
        return false;
    }

    /** Insert an element into the BST. */
    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }

    /** Create a new tree node. */
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    /** Inorder traversal of BST. */
    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
    }

    /** Preorder traversal of BST. */
    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root != null) {
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    /** Postorder traversal of BST. */
    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element + " ");
        }
    }

    /** Return size of the tree. */
    @Override
    public int getSize() {
        return size;
    }

    /** Return root of the tree. */
    public TreeNode<E> getRoot() {
        return root;
    }

    /** Return the path from root to a specific element. */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root;
        while (current != null) {
            list.add(current);
            if (c.compare(e, current.element) < 0)
                current = current.left;
            else if (c.compare(e, current.element) > 0)
                current = current.right;
            else
                break;
        }
        return list;
    }

    /** Delete an element from the BST. */
    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null)
            return false;

        // Case 1: Node has no left child
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (c.compare(e, parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            // Case 2: Node has a left child
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true;
    }

    /** Return an inorder iterator. */
    @Override
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    /** Clear the BST. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Tree node class representing a single element in the tree. */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    /** Inorder iterator for traversing the tree. */
    private class InorderIterator implements java.util.Iterator<E> {
        private java.util.ArrayList<E> list = new java.util.ArrayList<>();
        private int current = 0;

        public InorderIterator() {
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            if (current == 0)
                throw new IllegalStateException();
            delete(list.get(--current));
            list.clear();
            inorder(root);
        }
    }
}