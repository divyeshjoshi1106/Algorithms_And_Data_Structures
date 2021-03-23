/**
 * Write a description of class Main here.
 *
 * @author (Divyesh Joshi)
 * @version (10.01.2020)
 */
public class Main
{
    public static void main(String[] args) { 
        System.out.println("Please enter pre-order traveral encoded sequence: ");
        PrefixFreeDecoder p1 = new PrefixFreeDecoder();

        String test1 = "she_sells_sea_shells_by_the_seashore";
        System.out.println("\nOriginal Text = "+test1);
        String s1 = p1.encode(test1);
        System.out.println("No of bits in encoded string: "+s1.length());
        p1.decode(s1);

        String test2 = "selly_sells_her_shorts_by_the_seattle_store";
        System.out.println("\nOriginal Text = "+test2);
        String s2 = p1.encode(test2);
        System.out.println("No of bits in encoded string: "+s2.length());
        p1.decode(s2);
    }
}
