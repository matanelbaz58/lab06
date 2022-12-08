package il.ac.telhai.ds.trees;
import static java.lang.Math.max;

public class BinaryTree<T> implements BinaryTreeI<T>{
    private T t;
    private BinaryTreeI<T> left;
    private BinaryTreeI<T> right;





    public  BinaryTree(T t){
       this(t,null,null);
    }
    public  BinaryTree(T t,BinaryTreeI<T> left,BinaryTreeI<T> right) {
        this.t = t;
        this.left = left;
        this.right = right;

    }


    /**
     * @return the left subtree
     */
    @Override
    public BinaryTreeI<T> getLeft() {
        return left;
    }

    /**
     * @return the right subtree
     */
    @Override
    public BinaryTreeI<T> getRight() {
        return  right;
    }

    /**
     * @return the value in the root
     */
    @Override
    public T getValue() {
        return t;
    }

    /**
     * @param value set the value in the root
     */
    @Override
    public void setValue(T value) {
        t = value;
    }

    /**
     * @param left set the left subtree
     */
    @Override
    public void setLeft(BinaryTreeI<T> left) {
        this.left = left;
    }

    /**
     * @param right set the right subtree
     */
    @Override
    public void setRight(BinaryTreeI<T> right) {
        this.right = right;
    }

    /**
     * @return if it is a leaf or not.
     */
    @Override
    public boolean isLeaf() {
        return (left == null && right == null);
    }

    /**
     * @return the height of the tree, i.e. the length of a longest path starting
     * from the root.
     */
    @Override
    public int height() {
        if(isLeaf())
            return 0;
        int left_size = 0;
        int right_size = 0;
        if(left != null)
            left_size = left.height()+1;
        if(right != null)
            right_size = right.height()+1;
        return max(right_size,left_size);
    }

    /**
     * @return the number of nodes in the tree
     */
    @Override
    public int size() {
        if(isLeaf())
            return 1;
        int left_size = 0;
        int right_size = 0;
        if(left != null)
            left_size = left.size();
        if(right != null)
            right_size = right.size();
        return right_size+left_size+1;
    }

    /**
     * clears all the tree except its root.
     */
    @Override
    public void clear() {
       left = null;
       right = null;
    }

    /**
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in preorder fashion, where adding a " " before and
     * a " " after each value in the tree.
     */
    @Override
    public String preOrder() {
      return this.preOrder(" ", " ");
    }

    /**
     * @param separationBeforeVal
     * @param separationAfterVal
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in preorder fashion, where adding a
     * "separationBeforeVal" before each value and a
     * "separationAfterVal" after each value in the tree.
     */
    @Override
    public String preOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder s = new StringBuilder(separationBeforeVal+t.toString()+separationAfterVal) ;
        if(left!=null)
            s.append( left.preOrder(separationBeforeVal,separationAfterVal));
        if(right!= null)
            s.append( right.preOrder(separationBeforeVal,separationAfterVal));
        return s.toString() ;
    }

    /**
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in inorder fashion, where adding a " " before and
     * a " " after each value in the tree.
     */
    @Override
    public String inOrder() {
     return this.inOrder(" "," ");
    }

    /**
     * @param separationBeforeVal
     * @param separationAfterVal
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in inorder fashion, where adding a
     * "separationBeforeVal" before each value and a
     * "separationAfterVal" after each value in the tree.
     */
    @Override
    public String inOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder s = new StringBuilder();
        if(left!=null) {
            s.append(left.inOrder(separationBeforeVal,separationAfterVal));
        }
        s.append(separationBeforeVal);
        s.append(t.toString());
        s.append(separationAfterVal);
        if(right!= null) {

            s.append(right.inOrder(separationBeforeVal,separationAfterVal));
        }
        return  s.toString();
    }

    /**
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in postorder fashion, where adding a " " before
     * and a " " after each value in the tree.
     */
    @Override
    public String postOrder() {
        return this.postOrder(" "," ");
    }

    /**
     * @param separationBeforeVal
     * @param separationAfterVal
     * @return the concatenation of the string representations of the data values in
     * the tree traversed in postorder fashion, where adding a
     * "separationBeforeVal" before each value and a
     * "separationAfterVal" after each value in the tree.
     */
    @Override
    public String postOrder(String separationBeforeVal, String separationAfterVal) {
        StringBuilder s = new StringBuilder();
        if(left!=null)
            s.append(left.postOrder(separationBeforeVal,separationAfterVal) );
        if(right!= null)
            s.append( right.postOrder(separationBeforeVal,separationAfterVal));
        s.append(separationBeforeVal + t.toString() +separationAfterVal );
        return  s.toString() ;
    }
}
