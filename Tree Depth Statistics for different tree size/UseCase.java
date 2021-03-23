import java.util.Random;
/**
 *  This class UseCase is for demonstration only! 
 * @author Wolfgang Renz, Divyesh Joshi
 * @version Dec. 15, 2020
 */
public class UseCase
{
    private static final int kmax= 15;
    private final SymbolTable<Integer,Integer> bst;
    private static int size;
    private final static int iterations = 20; 
    private static Random generator = new Random();

    UseCase(int size, TreeCase tree) {
        // initialise instance variables
        if(tree == TreeCase.BST) bst = new BST<>();
        else bst = new RedBlackBST<>();
        this.size = size;
        initRandom();
    }

    private void initRandom() {
        for(int i=0; i<size; i++) {
            Integer key = generator.nextInt();
            Integer counter = bst.get(key);
            if(counter == null) bst.put(key,1);
            else bst.put(key, counter + 1);
        }
    }

    private int getMax()
    {   
        return bst.maxTreeDepth();
    }

    private double getMean()
    {   
        return bst.meanTreeDepth();
    }

    @Override
    public String toString() {
        return " case for size " + size + ":";
    }

    public static void makeTable() {

        for(TreeCase tree: TreeCase.values()){
            System.out.println("\n"+tree);
            System.out.println("\nFormatted Columns Header: \n\t  N, #(Max Depth), #(Mean Depth)");
            String format= "suitable format";

            for(int k=3; k<=kmax; k++) {
                int N= Double.valueOf(Math.pow(2, k)).intValue();
                
                double totalMax = 0;
                double totalMean = 0;

                for(int i = 0; i < iterations; i++) {
                    UseCase usecase= new UseCase(N,tree);
                    totalMax += usecase.getMax();
                    totalMean += usecase.getMean();
                }
                
                totalMax /= iterations;
                totalMean /= iterations;

                String results = String.format(" %10d %10.2f %10.2f",
                N, totalMax, totalMean); 
                System.out.println(results);

            }
        }

    }

    public static void main(String arg [] )
    {
       makeTable();
    }
}