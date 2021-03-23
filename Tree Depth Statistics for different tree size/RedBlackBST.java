import java.util.Iterator;
import java.util.Stack;
/**
 * Write a description of class RedBlackBST here.
 *
 * @author (Divyesh Joshi)
 * @version (Dec. 15. 2020)
 */
public class RedBlackBST <Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>, Iterable<Key>
{
    // instance variables 
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private int max, sumDepths, numNodes;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        boolean color; // Color of incoming link from parent Node.
        Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    private class BSTIterator implements Iterator<Key> {
        private Stack<Node> stack = new Stack<>();

        private void pushLeft(Node x) {
            while(x != null) {
                stack.push(x);
                x = x.left;
            }
        }

        BSTIterator() {
            pushLeft(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Key next() {
            Node x = stack.pop();
            pushLeft(x.right);
            return x.key;
        }
    }

    public Iterator<Key> iterator() 
    {
        return new BSTIterator();
    }

    public void remove(Key key) {
    }

    public boolean contains(Key key) 
    {
        return get(key) != null;
    }

    public void put(Key key, Value val)
    {
        root = insert(root, key, val);
        root.color = BLACK;
    }

    private Node insert(Node x, Key key, Value val) {
        if(x == null) return new Node(key, val, RED);
        if(isRed(x.left) && isRed(x.left.left)) x = splitFourNode(x);
        int cmp = key.compareTo(x.key);
        if(cmp == 0) x.val = val;
        else if(cmp < 0) x.left = insert(x.left, key, val);
        else x.right = insert(x.right, key, val);
        if(isRed(x.right)) x = leanLeft(x);
        return x;
    }

    private boolean isRed(Node x)
    {
        if (x == null) return false;
        return (x.color == RED);
    }

    private Node splitFourNode(Node h)
    {
        Node x = rotateRight(h);
        x.left.color = BLACK;
        return x;
    }

    private Node leanLeft(Node h)
    {
        Node x = rotateLeft(h);
        x.color = x.left.color;
        x.left.color = RED;
        return x;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        return x;
    }

    public Value get(Key key)
    {
        Node x = root;
        while (x != null)
        {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.val;
            else if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
        }
        return null;
    }

    public int maxTreeDepth() {
        max = 0;
        sumDepths = 0;
        numNodes = 0;
        traverse(root, max );
        return max;
    }

    private void traverse(Node node, int depth) {
        sumDepths += depth; 
        numNodes++;
        if(depth > max) max = depth;
        if(node.left != null) traverse(node.left, depth + 1);
        if(node.right != null) traverse(node.right, depth + 1);
    }

    public double meanTreeDepth() {
        maxTreeDepth();
        return (double)sumDepths / numNodes;
    }
}
