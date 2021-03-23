import java.util.*;
import java.util.StringTokenizer;
import java.lang.Math;
import java.lang.Object;
/**
 * A class whic stores an expression and evalutes a postfix expression.
 *
 * @author (Divyesh Joshi)
 * @version (a version 1)
 */
public class ArithmeticTerm
{
    // instance variables - replace the example below with your own
    private String exp;
    private Stack<String> stk;
    /**
     * Constructor for objects of class ArithmeticTerm
     */
    public ArithmeticTerm(String exp)
    {
        // initialise instance variables
        this.exp = exp;
        stk = new Stack<String>();
    }
    
    public void setExpression(String exp)
    {
        this.exp = exp;
    }
    
    public String toString()
    {
        return exp;
    }

    public void reverse()
    {
        System.out.println("Expression:"+exp);
        StringTokenizer st = new StringTokenizer(exp);
        while(st.hasMoreTokens())
        {
            stk.push(st.nextToken());
        }

        String s = "";
        while(!stk.empty())
        {
            s = s.concat(stk.lastElement()); 
            s = s.concat(" ");
            stk.pop();
        }
        System.out.println("After Reversing:"+s);
    }

    public double evaluate()
    {
        StringTokenizer st = new StringTokenizer(exp);

        StackOfDoubles stack1 = new StackOfDoubles();

        while(st.hasMoreTokens())
        {
            String s = st.nextToken();

            try{ 
                double d = Double.parseDouble(s);
                stack1.push(d);

            }
            catch(Exception e)
            {
                double d1 = stack1.pop();  

                switch(s)
                {
                    case "+":
                    stack1.push(stack1.pop()+d1);
                    break;

                    case "-":
                    stack1.push(stack1.pop()-d1);
                    break;

                    case "/":
                    stack1.push(stack1.pop()/d1);
                    break;

                    case "*":
                    stack1.push(stack1.pop()*d1);
                    break;

                    case "^":
                    stack1.push(Math.pow(stack1.pop(),d1));
                    break;

                    case "sqrt":
                    stack1.push(Math.sqrt(d1));
                    break;

                    case "++":
                    stack1.push(d1+1);
                    break;

                    case "--":
                    stack1.push(d1-1);
                    break;
                }
            }
        }
        return stack1.pop();
    }
    
    /**
     * Converts a FPAE into postfix notation.
     * @return The FPAE in postfix notation.
     */
    public String convert() {
        Stack<String> operators = new Stack<>();
        StringTokenizer tokenizer = new StringTokenizer(exp);
        String result = "";
        int count = 0;

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals("+") || token.equals("-") || token.equals("*")
                    || token.equals("/") || token.equals("^") || token.equals("%")
                    || token.equals("sqrt") || token.equals("++") || token.equals("--")) {
                operators.push(token);
            } else if (token.equals("(")) {
                count++;
            } else if (token.equals(")")) {
                count--;
                result += operators.pop() + " ";
            } else if(token.matches("[+-]?\\d*(e[+-]?\\d+|\\.[0-9]+)?")) {
                result += Double.parseDouble(token) + " ";
            } else {
                System.out.printf("Illegal value detected : %s", token);
            }
        }

        if(count != 0) {
            System.out.printf("The number of parentheses is incorrect.");
            System.exit(1);
        }

        return result;
    }
}
