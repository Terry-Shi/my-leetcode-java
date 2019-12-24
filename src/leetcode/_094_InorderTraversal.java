package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _094_InorderTraversal {

  public static void main(String[] args) {
    TreeNode node = TreeNodeHelper.stringToTreeNode("1,2,3,4,5,6,7");
    List<Integer> ret = new ArrayList<>();
    inorderTraversal(ret, node);
    System.out.println(ret);
    System.out.println(inorderTraversal2(node));
  }

  //递归
  public static void inorderTraversal(List<Integer> ret, TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      inorderTraversal(ret, root.left);
    }                    

    ret.add(root.getVal());

    if (root.right != null) {
      inorderTraversal(ret, root.right);
    }
  }
  // 借助栈的迭代方法
  public static List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> ret = new ArrayList<>();
    if (root == null) {
      return ret;
    }
    Stack<TreeNode> rootNodes = new Stack<>();
    TreeNode currentNode = root;
    while (currentNode != null || !rootNodes.isEmpty()) {
      while (currentNode != null) {
        rootNodes.push(currentNode);
        currentNode = currentNode.left;
      }
      currentNode = rootNodes.pop();
      ret.add(currentNode.getVal());
      currentNode = currentNode.right;
    }
    return ret;
  }

}
