
/**
 * Write a description of class Stack here.
 *
 * @author (Divyesh Joshi)
 * @version (version 1)
 */
public class GenericStack<T>
{
    // instance variables - replace the example below with your own
    private Node first = null;

    private class Node
    {
        T item;
        Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void push(T item)
    {
        Node second = first;
        first = new Node();
        first.item = item;
        first.next = second;
    }

    public T pop()
    {
        T item = first.item;
        first = first.next;
        return item;
    }

}
