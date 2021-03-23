
/**
 * Write a description of class Main here.
 *
 * @author (Divyesh Joshi)
 * @version (version 1)
 */
public class Main
{
   public static void main(String[] args)
    {
        //test-code that builds up a sample tree
        System.out.println("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *");
        Tree tree1= new Tree("5.1 9 8.88 + 4 sqrt 6 / ^ 7 - *"); // example from lab 1 problem 2
        tree1.postorderTraversal();
        
        System.out.println("\n4.0 pi * 3.0 / sin -1 2.0 sqrt 1.0 - * 8.0 / exp * 6.0 pi * sqrt /");
        Tree tree2= new Tree("4.0 pi * 3.0 / sin -1 2.0 sqrt 1.0 - * 8.0 / exp * 6.0 pi * sqrt /");
        tree2.postorderTraversal();
        
        System.out.println("\n3 4 5 + sin *");
        Tree tree3= new Tree("3 4 5 + sin *");
        tree3.postorderTraversal();
        
        System.out.println("\n2 pi * cos 6 pi * sqrt *");
        Tree tree4= new Tree("2 pi * cos 6 pi * sqrt *");
        tree4.postorderTraversal();
        
        System.out.println("\n5 7 pi 2 / sin ^ 2 exp + *");
        Tree tree5= new Tree("5 7 pi 2 / sin ^ 2 exp + *");
        tree5.postorderTraversal();
        
    }
}
