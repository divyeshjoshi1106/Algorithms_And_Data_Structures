
/**
 * Main class of this project for lab 1
 *
 * @author (Divyesh Joshi)
 * @version (version 1)
 */
public class Main
{
    private static ArithmeticTerm arithmet1 = new ArithmeticTerm("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
        //Problem 2 example in reverse.
        arithmet1.reverse();
        //Problem 3 example in reverse.
        arithmet1.setExpression("( 5.1 * ( ( ( 9 + 8.88 ) ^ ( ( sqrt 4 ) / 6 ) ) - 7 ) )");
        arithmet1.reverse();
        
        arithmet1.setExpression("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");
        System.out.printf("\n\"%s\" -> \"%f\"", arithmet1.toString(), arithmet1.evaluate());
        
        arithmet1.setExpression("7 4 -3 * 1 5 + / *");
        System.out.printf("\n\"%s\" -> \"%f\"", arithmet1.toString(), arithmet1.evaluate());
        
        arithmet1.setExpression("6 2 + 5 * 8 4 / -");
        System.out.printf("\n\"%s\" -> \"%f\"", arithmet1.toString(), arithmet1.evaluate());
        
        arithmet1.setExpression("18 3 / 2 ^ 13 7 + 5 2 ^ * +");
        System.out.printf("\n\"%s\" -> \"%f\"", arithmet1.toString(), arithmet1.evaluate());
        
        arithmet1.setExpression("2 20 * 2 / 3 3 ++ + 3 2 ^ * + 6 - 15 +");
        System.out.printf("\n\"%s\" -> \"%f\"", arithmet1.toString(), arithmet1.evaluate());
        
        main2();
        
    }
    
    public static void main2() {
       
        arithmet1.setExpression("( 5.1 * ( ( ( 9 + 8.88 ) ^ ( ( sqrt 4 ) / 6 ) ) - 7 ) )");
        System.out.println("\n\nFPAE expression: "+arithmet1.toString());
        arithmet1.setExpression(arithmet1.convert());
        System.out.println("Converted to postfix: "+arithmet1.toString());
        System.out.println("Evaluates to:"+arithmet1.evaluate());
    }
}
