import java.util.Random;
/**
 *  This class UseCase is for demonstration only!
 *  It shows how to use enum in switch/case, loop over it's values and it's name printing.
 * 
 * @author Wolfgang Renz, Divyesh Joshi
 * @version Nov. 14, 2020
 */
public abstract class UseCase
{
    public static final int kmax= 13;
    public static final int Nmax= (int) Math.round(Math.pow(2, kmax));
    public static final int M= 20;  // sample size
    public static Double[] arr;
    // instance variables:
    private InputCase inputCase;
    private int size;
    private int iterations; //for averaging a sample
    protected int comp, copy; //results to be written by sub-class
    //protected Comparable[] numList;
    private Random generator = new Random(2505050);

    abstract void sortAndCount();

    protected UseCase(InputCase inputCase, int size) {
        // initialise instance variables
        this.size = size;
        this.inputCase= inputCase;
        arr = new Double[size];
        for(int i = 0; i < size; i++)
            arr[i] = 0.0;
        if (inputCase == InputCase.AVG) {
            iterations = M;
        } else {
            iterations= 1;
        }

        switch(inputCase) {
            case SORTED: initAscending(); break;
            case REVERSE: initDescending(); break;
            case RANDOM: case AVG: initRandom(); break;
            default:
            ;
        }
    }

    private void initAscending() {
        for(int i=0; i<size; i++) {
            arr[i] = generator.nextDouble() + i;
        }
    }

    private void initDescending() {
        for(int i=0; i<size; i++) {
            arr[i] = generator.nextDouble() - i;
        }
    }

    private void initRandom() {
        for(int i=0; i<size; i++) {
            arr[i] = generator.nextDouble();
        }
    }

    @Override
    public String toString() {
        return inputCase + " case for size " + size + ":";
    }

    String getResults(String format) {
        int totalComp = 0, totalCopy = 0;
        for(int i = 0; i < iterations; i++) {
            sortAndCount();
            totalComp += comp;
            totalCopy += copy;
            initRandom();
        }
        comp = totalComp / iterations;
        copy = totalCopy / iterations;
        String results;
        
        results = String.format("%10s comparisons & %10s copies", comp, copy);
        return results;
    }

    public void writeResults(String format) {
        System.out.println(String.format("N - %4d", size) + getResults(format));
    }

    public static void makeTable(String sortCase) {
        for (InputCase tableCase: InputCase.values()) {
            int N=1;
            System.out.println(tableCase + " case:");
            System.out.println("\nFormatted Columns Header: N, #(cmp), #(cpy)");
            String format= "suitable format";
            for(int k=1; k<=kmax; k++) {
                N*= 2;
                UseCase usecase = null;
                switch(sortCase) {
                    case "SortCase": usecase= new SortCase(tableCase, N); break;
                    case "SelectionCase": usecase= new SelectionCase(tableCase, N); break;
                    case "MergesortCase": usecase= new MergesortCase(tableCase, N); break;
                    
                }
                // check for all sort cases and instantiate them accordingly!
                if(usecase != null) {
                    usecase.writeResults(format);
                }
            }
        }
    }

    public static void main(String arg [] )
    {
        System.out.println("Selection sort case:");
        makeTable("SelectionCase");
        System.out.println("Merge sort case:");
        makeTable("MergesortCase");
        

    }
}