import java.util.Random;
/**
 * Abstract class Sort is responsible for operations and their counting.
 *
 * @author Wolfgang Renz, Divyesh Joshi
 * @version Nov. 22, 2020
 */
public abstract class Sort
{
    protected static int copies = 0;
    protected static int compares = 0;

    protected static void reset()
    {
        copies = 0;
        compares = 0;
    }
    
    protected static void copy(Comparable[] dest, int i, Comparable[] source, int j)
    {
        dest[i] = source[j];
        copies++;
    }

    protected static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        copies += 3;
    }

    protected static boolean less(Comparable v, Comparable w)
    {
        compares++;
        return (v.compareTo(w) < 0);
    }
    
    protected static boolean isSorted(Comparable a[], int left, int right)
    {
        boolean isSorted = true;
        for(int i=left; i<right; i++)
        {
            if(a[i].compareTo(a[i+1])>0)
            {
                isSorted = false;
            }
        }
        return isSorted;
    }

    protected static boolean isPartitioned(Comparable a[], int left, int border, int right)
    {
        boolean partitioned = false;
        Comparable leftPart = a[left], rightPart = a[border];

        // Find largest element in left partition.
        for(int i = left+1; i < border; i++)
            if(leftPart.compareTo(a[i]) < 0)
                leftPart = a[i];

        // Find smallest element in right partition.
        for(int i = border+1; i < right; i++)
            if(rightPart.compareTo(a[i]) > 0)
                rightPart = a[i];

        // Compare, largest element in left should be equal or smaller than smallest element in right.
        if(leftPart.compareTo(rightPart) <= 0)
            partitioned = true;

        return partitioned;
    }

    public static int getComp()
    {
        return compares;
    }

    public static int getCopy()
    {
        return copies;
    }
}
