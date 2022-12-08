package il.ac.telhai.ds.trees;

import java.io.IOException;
import java.io.StreamTokenizer;

public class ExpressionTree extends FullBinaryTree<String> {
    public ExpressionTree(String s) {
        super(s);
    }

    public ExpressionTree(String s, BinaryTreeI<String> left, BinaryTreeI<String> right) {
        super(s, left, right);
    }

    /*
     * Read the stream tokenizer until EOF and construct
     *  the expression tree corresponding to it.
     * The input contains a prefix expression.
     */
    public static ExpressionTree createTree(StreamTokenizer tokenizer) throws IOException {
        tokenizer.nextToken();
        if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {//if this a +*
            return new ExpressionTree(Integer.toString((int) tokenizer.nval));
        } else {
            return new ExpressionTree(String.valueOf(Character.toChars(tokenizer.ttype)), createTree(tokenizer), createTree(tokenizer));

        }
    }

    /*
     * Returns the infix expression corresponding to the current tree (*)
     */
    public String infix() {

        return inOrder("(", ")");
    }

    @Override
    public String inOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder s = new StringBuilder();
        if (isLeaf()) {
            s.append(getValue());
            return s.toString();

        }
        s.append(separationBeforeVal);
        s.append(getLeft().inOrder(separationBeforeVal, separationAfterVal));
        s.append(" ");
        s.append(getValue());
        s.append(" ");
        s.append(getRight().inOrder(separationBeforeVal, separationAfterVal));
        s.append(separationAfterVal);
        return s.toString();
    }

    /*
     * Returns the prefix expression corresponding to the current tree (*)
     */
    public String prefix() {
        return preOrder();
    }



    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /*
     * Evaluates the expression corresponding to the current tree
     * and returns its value
     */

    public double evaluate() {
        if (isNumeric(getValue())) {
            return Double.parseDouble(getValue());
        } else {

            return helper_res(getValue(), ((ExpressionTree) getLeft()).evaluate(), ((ExpressionTree) getRight()).evaluate());

        }
    }

    public double helper_res(String operator, double a, double b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 1;
        };
    }
}
