
/**
 * Enumeration class TreeCase - write a description of the enum class here
 *
 * @author (Divyesh Joshi)
 * @version (14. Dec. 2020)
 */
public enum TreeCase
{
    BST("BST Case"), 

    RBT("Red Black Tree");
    
    String name;
    
    TreeCase(String name)
    {
        this.name=name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
