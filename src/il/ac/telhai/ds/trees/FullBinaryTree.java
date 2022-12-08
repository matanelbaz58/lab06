package il.ac.telhai.ds.trees;

public class FullBinaryTree<T> extends BinaryTree<T> {

    public FullBinaryTree(T t) {
        this(t, null, null);


    }

    public FullBinaryTree(T t, BinaryTreeI<T> left, BinaryTreeI<T> right) {
        super(t, left, right);
        if (left == null ^ right == null)
            throw new IllegalArgumentException();


    }

    @Override
    public void setRight(BinaryTreeI<T> right)  {
        boolean a = (getLeft()== null && getRight() == null && right != null);
        boolean b = (getLeft() != null && getRight() != null && right == null);
        if(right == null&& getLeft() == null)
            return;
        if ((a || b) || !(right instanceof FullBinaryTree<T>)) {
            throw new IllegalArgumentException();
        } else super.setRight(right);

    }

    @Override
    public void setLeft(BinaryTreeI<T> left) {
        boolean a = (getLeft() == null && getRight() == null && left != null);
        boolean b = (getRight() != null && getLeft() != null && left == null);
        if(left == null&& getRight() == null)
            return;
        if ((a || b) || !(left instanceof FullBinaryTree<T>)) {
            throw new IllegalArgumentException();
        } else super.setLeft(left);


    }
}



