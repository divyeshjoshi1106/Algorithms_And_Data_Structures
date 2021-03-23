
/**
 * Write a description of class Merge here.
 *
 * @author (Divyesh Joshi)
 * @version (v2)
 */
public class Merge extends Sort
{
    // instance variables - replace the example below with your own
    private static void merge(Comparable[] a,
    Comparable[] aux, int l, int m, int r)
    {
        for (int k = l; k < r; k++) copy(aux,k,a,k);//aux[k] = a[k];
        int i = l, j = m;
        for (int k = l; k < r; k++)
        {    if (i >= m) copy(a,k,aux,j++);//a[k] = aux[j++];
            else if (j >= r) copy(a,k,aux,i++);//a[k] = aux[i++];
            else if (less(aux[j], aux[i])) copy(a,k,aux,j++);//a[k] = aux[j++];
            else copy(a,k,aux,i++);//a[k] = aux[i++];

        }
    }    

    private static void sort(Comparable[] a,
    Comparable[] aux, int lo, int hi)
    {
        if (hi <= lo + 1) return;
        int m = lo + (hi - lo) / 2;
        sort(a, aux, lo, m);
        sort(a, aux, m, hi);
        merge(a, aux, lo, m, hi);
       
    }

    public static void sort(Comparable[] a)
    {
        reset();
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length);
    }
    
    // private static void merge(Comparable[] a, Comparable[] aux,
    // int l, int m, int r)
    // {
        // for (int i = l; i < m; i++) copy(aux,i,a,i);//aux[i] = a[i];
        // for (int j = m; j < r; j++) copy(aux,j,a,m + r - j - 1);//aux[j] = a[m + r - j - 1];
        // int i = l, j = r - 1;
        // for (int k = l; k < r; k++)
            // if (less(aux[j], aux[i])) copy(a,k,aux,j--);//a[k] = aux[j--];
            // else copy(a,k,aux,i++);//a[k] = aux[i++];
    // }

    // public static void sort(Comparable[] a)
    // {
        // reset();
        // int N = a.length;
        // Comparable[] aux = new Comparable[N];
        // for (int m = 1; m < N; m = m+m)
            // for (int i = 0; i < N-m; i += m+m)
                // merge(a, aux, i, i+m, Math.min(i+m+m, N));
    // }
}
