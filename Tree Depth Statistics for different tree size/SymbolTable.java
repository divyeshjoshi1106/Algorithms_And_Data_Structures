import java.util.Iterator;

/**
 * Write a description of interface SymbolTable here.
 *
 * @author (Divyesh Joshi)
 * @version (14. Dec. 2020)
 */
public interface SymbolTable <Key extends Comparable<Key>, Value>
{
    void put(Key key, Value val);
    Value get(Key key);
    boolean contains(Key key);
    void remove(Key key);
    Iterator<Key> iterator();
    int maxTreeDepth();
    double meanTreeDepth();
}
