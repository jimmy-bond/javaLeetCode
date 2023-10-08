package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class  TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;this.left = left;
        this.right = right;
    }
}
class Solution {
     //前序遍历，中序遍历，后序遍历相差不大，只有遍历时的顺序不同而已
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //递归实现方法
       /*
        preorder(root,list);
        return list;*/
        //迭代实现方法，用栈来保存，
    /*    Stack<TreeNode> stack =new Stack<>();
        if(root == null) return null;
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode no = stack.pop();
            list.add(no.val);
            if(no.right != null) stack.push(no.right);
            if(no.left != null) stack.push(no.left);
        }
        return list;*/
        //迭代实现中序遍历，即左中右方法遍历,和前序遍历相差不一样
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            if(node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;

    }
    //递归实现方法
    public void preorder(TreeNode t,List<Integer>l)
    {
        if(t == null) return;
        l.add(t.val);
        preorder(t.left,l);
        preorder(t.right,l);
    }
    //统一迭代风格方法,采用标记法，访问过的根节点后面进栈要加null指针
    //这个是中序遍历的方法
    public void pre(TreeNode root)
    {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
       if(root != null) {
           stack.push(root);
       }
       while (!stack.isEmpty())
       {
           TreeNode t = stack.peek();

           if(t != null)
           {
               stack.pop();
               if(t.right != null) stack.push(root.right);
               stack.push(t);
               stack.push(null);
               if(t.left != null) stack.push(t.left);
           }
           else{
               t = stack.peek();
               list.add(t.val);
               stack.pop();
           }
       }
    }
}
