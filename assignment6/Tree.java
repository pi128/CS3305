// Name: James Widner
// Class: CS3305/W01
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #6
// IDE Name: VSC



import java.util.Collection;

/**
 * Tree interface representing a generic binary tree structure.
 * Includes basic operations such as insert, delete, search, and traversals.
 * Extends Java's Collection interface to provide compatibility with collections.
 */
public interface Tree<E> extends Collection<E> {

    /**
     * Determines whether the specified element exists in the tree.
     * 
     * @param e the element to search for
     * @return true if the element exists in the tree, false otherwise
     */
    public boolean search(E e);

    /**
     * Inserts the specified element into the tree.
     * 
     * @param e the element to insert
     * @return true if insertion is successful, false if it already exists
     */
    public boolean insert(E e);

    /**
     * Deletes the specified element from the tree.
     * 
     * @param e the element to delete
     * @return true if deletion is successful, false if the element is not found
     */
    public boolean delete(E e);

    /**
     * Returns the number of elements in the tree.
     * 
     * @return the size of the tree
     */
    public int getSize();

    /**
     * Performs an inorder traversal starting from the root.
     * Default implementation does nothing.
     */
    public default void inorder() {}

    /**
     * Performs a postorder traversal starting from the root.
     * Default implementation does nothing.
     */
    public default void postorder() {}

    /**
     * Performs a preorder traversal starting from the root.
     * Default implementation does nothing.
     */
    public default void preorder() {}

    /**
     * Checks if the tree is empty.
     * 
     * @return true if the tree has no elements, false otherwise
     */
    @Override
    public default boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public default boolean contains(Object e) {
        return search((E)e);
    }

    @Override
    public default boolean add(E e) {
        return insert(e);
    }

    @Override
    public default boolean remove(Object e) {
        return delete((E)e);
    }

    @Override
    public default int size() {
        return getSize();
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        // Not implemented
        return false;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        // Not implemented
        return false;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
        // Not implemented
        return false;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        // Not implemented
        return false;
    }

    @Override
    public default Object[] toArray() {
        // Not implemented
        return null;
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        // Not implemented
        return null;
    }
}