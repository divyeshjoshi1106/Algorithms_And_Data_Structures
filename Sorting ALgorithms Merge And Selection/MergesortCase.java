
/**
 * Write a description of class MergeCase here.
 *
 * @author (Divyesh Joshi)
 * @version (v1)
 */
public class MergesortCase extends UseCase
{
    // instance variables - replace the example below with your own
   /**
     * Constructor for objects of class MergeCase
     */
    public MergesortCase(InputCase inputCase, int size)
    {
        // initialise instance variables
        super(inputCase, size);
    }

    @Override
    public String toString()
    {
        return "Mergsesort, " + super.toString();
    }
    
    public void sortAndCount()
    {
       Merge.sort(arr);
       comp = Sort.getComp();
       copy = Sort.getCopy();
    }
}
