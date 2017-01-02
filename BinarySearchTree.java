import java.util.*;

public class BinarySearchTree {

  class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;

    TreeNode(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }

    public int getData() {
      return this.data;
    }

    public void setData(int data) {
      this.data = data;
    }

    public TreeNode getLeft() {
      return this.left;
    }

    public void setLeft(TreeNode t) {
      this.left = t;
    }

    public TreeNode getRight() {
      return this.right;
    }

    public void setRight(TreeNode t) {
      this.right = t;
    }

  }

  private TreeNode root;

  BinarySearchTree() {
    this.root = null;
  }

  public void insert(int num) {
    this.root = insert(this.root, num);
  }

  public TreeNode insert(TreeNode curr, int num) {

    if(curr == null) {
      return new TreeNode(num);
    }

    else if (curr.getData() >= num) {
      curr.setLeft(insert(curr.getLeft(), num));
    }
    else {
      curr.setRight(insert(curr.getRight(), num));
    }
    return curr;
  }

  public boolean find(int num) {
    return find(this.root, num);
  }

  public boolean find(TreeNode curr, int num) {

    if (curr == null) {
      return false;
    }
    else if (curr.getData() == num) {
      return true;
    }
    else if (curr.getData() > num) {
      return find(curr.getLeft(), num);
    }
    else {
      return find(curr.getRight(), num);
    }
  }

  public void delete(int num) {
    this.root = delete(this.root, num);
  }

  public TreeNode delete(TreeNode curr, int num) {
    if(curr == null) {
      return curr;
    }
    else if(curr.getData() == num) {
      if(curr.getLeft() == null && curr.getRight() == null) {
        return null;
      }
      else if(curr.getLeft() == null && curr.getRight() != null) {
        return curr.getRight();
      }
      else if(curr.getRight() == null && curr.getLeft() != null) {
        return curr.getLeft();
      }
      else {
        TreeNode temp = curr.getRight();
        while(temp.getLeft() != null) {
          temp = temp.getLeft();
        }
        curr.setData(temp.getData());
        curr.setRight(delete(curr.getRight(), curr.getData()));
      }
    }
    else if(curr.getData() > num) {
      curr.setLeft(delete(curr.getLeft(), num));
    }
    else {
      curr.setRight(delete(curr.getRight(), num));
    }

    return curr;
  }

  public void printTree() {
    printTree(this.root);
  }

  public void printTree(TreeNode curr) {
    if (curr == null) {
      return;
    }
    printTree(curr.getLeft());
    System.out.print(curr.getData() + " ");
    printTree(curr.getRight());

  }

  public static void main(String[] args) {
    BinarySearchTree t = new BinarySearchTree();
    t.insert(5);
    t.insert(1);
    t.insert(2);
    t.insert(3);
    t.insert(6);
    t.insert(4);
    t.insert(8);
    t.insert(7);
    t.printTree();
    System.out.println("");
    System.out.println(t.find(1));
    System.out.println(t.find(6));
    System.out.println(t.find(9));
    t.delete(3);
    t.delete(8);
    t.delete(5);
    t.delete(9);
    t.printTree();
    System.out.println("");

  }

}
