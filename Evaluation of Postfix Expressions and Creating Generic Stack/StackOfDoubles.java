
/**
 * Array implementation of a stack.
 *
 * @author (Divyesh Joshi)
 * @version (Version 1)
 */
public class StackOfDoubles
{
    private Double[] s = new Double[1]; 
    private int N = 0;
    public void resize(int capacity)
    { 
        Double[] temp = new Double[capacity];
        for(int i=0; i<N; i++)
        {
            temp[i] = s[i];
        }
        s = temp;
    }

    public boolean isEmpty()
    { 
        return N == 0; 
    }

    public void push(Double item)
    { 
        if (N >= s.length) 
        {
            resize(s.length*2); 
        }
        s[N++] = item;
    }

    public Double pop()
    {
        double item = s[N-1];
        s[N-1] = null;
        N--;
        return item;
    }
}
