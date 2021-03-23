
/**
 * Write a description of class SelectionCase here.
 *
 * @author (Divyesh Joshi)
 * @version (v1)
 */
public class SelectionCase extends UseCase
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class SelectionCase
     */
    public SelectionCase(InputCase inputCase, int size)
    {
        // initialise instance variables
        super(inputCase, size);
    }

    @Override
    public String toString()
    {
        return "Selection Sort, " + super.toString();
    }

    public void sortAndCount()
    {
        Selection.sort(arr);
        comp = Sort.getComp();
        copy = Sort.getCopy();
    }
}
