import java.util.Stack;
import java.util.StringTokenizer;
import java.lang.Math;
/**
 * Tree: binary tree traversals
 * PREORDER, INORDER, POSTORDER implemented
 * ToDo: LEVELORDER
 * 
 * @author Divyesh Joshi 
 * @version Nov. 2020
 */
public class Tree
{
    private BiNode root;

    private static class BiNode //prep task 4.1
    {
        public String item; //content
        public BiNode left; //left child
        public BiNode right; //right child

        BiNode(String item) // Leaf constructor
        {
            this(item, null, null);
        }

        BiNode(String item, BiNode left, BiNode right) // inner node
        {
            this.item= item;
            this.right= right;
            this.left= left;
        }
    }

    public Tree(BiNode root)
    {
        this.root=root;
    }

    Tree(String postfix)
    {
        this.root = construct(postfix);
    }

    private boolean isOperator(String s) //checks if the string sent is an operator or not
    {
        switch (s)
        {
            case "*":
            case "/":
            case "^":
            case "+":
            case "-":
            case "sqrt":
            case "sin":
            case "cos":
            case "exp":
            return true;

            default:
            return false;
        }
    }

    BiNode construct(String postfix) //prep task 4.2
    {
        Stack<BiNode> stack1 = new Stack<>();
        StringTokenizer st = new StringTokenizer(postfix);
        while(st.hasMoreTokens())
        {
            String s = st.nextToken();

            if(isOperator(s))
            {
                if(s.equals("sqrt") || s.equals("sin") || s.equals("cos") || s.equals("exp"))
                {
                    if(stack1.isEmpty())
                    {
                        System.out.println("No Operand to perform task");
                        System.exit(2);
                    }
                    else
                    {
                        BiNode right = stack1.pop();
                        stack1.push(new BiNode(s,null,right));
                    }
                }
                else
                {
                    if(stack1.size()<2)
                    {
                        System.out.println("Not enough Operands to perform task");
                        System.exit(2);
                    }
                    else
                    {
                        BiNode right = stack1.pop();
                        BiNode left = stack1.pop();
                        stack1.push(new BiNode(s,left,right));
                    }
                }
            }
            else if(s.matches("[+-]?\\d*(e[+-]?\\d+|\\.[0-9]+)?"))
            { 
                stack1.push(new BiNode(s));
            }
            else if(s.equals("pi"))
            {
                stack1.push(new BiNode(String.valueOf(Math.PI)));
            }
            else
            {
                System.out.printf("%s is not a valid operand.", s);
                System.exit(2);
            }
        }
        if(stack1.size()!=1)
        {
            System.out.println("Operands left in stack without operator");
                        System.exit(2);
        }
        return stack1.pop();
    }

    public enum ORDER{
        PREORDER, INORDER, POSTORDER, LEVELORDER;
    }

    public void traverse(ORDER how)
    {
        switch(how){
            case PREORDER:
            System.out.println(how + ":");
            traversePRE(root);
            break;
            case INORDER:
            System.out.println(how + ":");
            traverseIN(root);
            break;
            case POSTORDER:
            System.out.println(how + ":");
            postorderTraversal(root);
            break;
        }
    }

    private StringBuffer indent= new StringBuffer();

    private void indentation(boolean plus)
    {
        if(plus) indent.append("    ");
        else indent.setLength(indent.length()-4);
    }

    private void visit(BiNode node)
    {
        System.out.println(indent.toString() + "visit(" + node.item + ")");
    }

    private void traversePRE (BiNode node)
    {
        indentation( true);
        System.out.println(indent.toString() + "traverse(" + node.item + ")");
        visit(node);
        if(node.left!=null) traversePRE (node.left);
        if(node.right!=null) traversePRE (node.right);
        System.out.println(indent.toString() + "return");
        indentation( false);
    }

    private void traverseIN (BiNode node)
    {
        indentation( true);
        System.out.println(indent.toString() + "traverse(" + node.item + ")");
        if(node.left!=null) traverseIN (node.left);
        visit(node);
        if(node.right!=null) traverseIN (node.right);
        System.out.println(indent.toString() + "return");
        indentation( false);
    }

    public void postorderTraversal()
    {
        postorderTraversal(root);
    }

    private void postorderTraversal(BiNode node)
    {
        indentation( true);
        System.out.println(indent.toString() + "traverse(" + node.item + ")");
        if(node.left!=null) postorderTraversal (node.left);
        if(node.right!=null) postorderTraversal (node.right);
        visit(node);
        System.out.println(indent.toString() + "return");
        indentation( false);
    }

    public static void main(String[]a)
    {
        //test-code that builds up a sample tree
        Tree tree= new Tree("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *"); // example from lab 1 problem 2
        for(ORDER how: ORDER.values())
        {
            tree.traverse(how);
        }
    }
}
