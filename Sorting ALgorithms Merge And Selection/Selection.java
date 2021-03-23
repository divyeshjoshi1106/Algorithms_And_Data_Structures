/**
 * class Selection from Sedgewick.
 *
 * @author Wolfgang Renz, Divyesh Joshi
 * @version Nov. 22, 2020
 */
public class Selection extends Sort
{
    public static void sort(Comparable[] a)
    {
        reset();
        int N = a.length;
        for (int i = 0; i < N-1; i++) // i: destination site
        {
            assert isSorted(a, 0, i); // to check the invariants
            int min = i; // index of minimum candidate
            for (int j = i+1; j < N; j++){
                if (less(a[j], a[min])){
                    min = j; // better minimum candidate found
                }
            }
            // now min is the index of the minimum
            exch(a, i, min);
        }
    }
    
}
