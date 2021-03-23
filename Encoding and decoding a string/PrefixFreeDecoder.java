import java.io.*;
import java.util.HashMap;
/**
 * Decode and Encode a string using coding tree.
 *
 * @author (Divyesh Joshi)
 * @version (10.01.2020)
 */
public class PrefixFreeDecoder
{
    private Node root = new Node();
    private HashMap<Character, String> charPrefix = new HashMap<>();
    private class Node
    {
        char ch;
        Node left, right;
        Node()
        {
            ch = StdIn.readChar();
            if (ch == '*'){
                left = new Node();
                right = new Node();
            }
        }

        boolean isInternal() {
            if((left != null) && (right != null))
                return true;
            else
                return false;
        }
    }

    public void decode(String s){
        StringBuilder str1 = new StringBuilder();

        Node x = root;

        System.out.println("Encoded: " + s);

        for (int i = 0; i < s.length(); i++) {
            int toInt = Integer.parseInt(String.valueOf(s.charAt(i)));

            if (toInt == 0) {
                x = x.left;
                if (x.left == null && x.right == null) {
                    str1.append(x.ch);
                    x = root;
                }
            }
            if (toInt == 1) {
                x = x.right;
                if (x.left == null && x.right == null) {
                    str1.append(x.ch);
                    x = root;
                }
            }
        }
        System.out.println("Decoded string is :" + str1.toString());
    }

    public String encode(String test){
        setPrefix(root, new StringBuilder());
        StringBuilder bits = new StringBuilder();

        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            bits.append(charPrefix.get(c));
        }
        return bits.toString();
    }

    private void setPrefix (Node node, StringBuilder prefix){
        if (node != null) {
            if (node.left == null && node.right == null) {
                charPrefix.put(node.ch, prefix.toString());
            } else {
                prefix.append('0');
                setPrefix(node.left, prefix);
                prefix.deleteCharAt(prefix.length() - 1);

                prefix.append('1');
                setPrefix(node.right, prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }
}
