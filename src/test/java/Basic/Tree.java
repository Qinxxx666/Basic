package Basic;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
/**
 * @Title: Tree
 * @Author Qin
 * @Package Basic
 * @Version
 * @Date 2024/7/4 15:30
 * @description:
 */
public class Tree {

     //Definition for a binary tree node.
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public static class TreeOpr{
         public static TreeNode init(Integer[] array){
             if (array == null || array.length == 0) {
                 return null;
             }

             TreeNode root = new TreeNode(array[0]);

             Queue<TreeNode> queue = new LinkedList<>();
             queue.offer(root);

             int index = 1;
             while (index < array.length) {
                 TreeNode node = queue.poll();

                 // Left child
                 if (index < array.length && array[index] != null) {
                     node.left = new TreeNode(array[index]);
                     queue.offer(node.left);
                 }
                 index++;

                 // Right child
                 if (index < array.length && array[index] != null) {
                     node.right = new TreeNode(array[index]);
                     queue.offer(node.right);
                 }
                 index++;
             }
             return root;
         }
        public static TreeNode reverse(TreeNode root){
            if(root == null) return null;
            TreeNode tmp = root.left;
            root.left = reverse(root.right);
            root.right = reverse(tmp);
            return root;
        }
        public static int maxDepth(TreeNode root) {
             //基于递归的深度优先算法
            if(root == null) return 0;
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
            //广度优先
//            if(root == null) return 0;
//            List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
//            int res = 0;
//            while (!queue.isEmpty()) {
//                tmp = new LinkedList<>();
//                for(TreeNode node : queue) {
//                    if (node.left != null) tmp.add(node.left);
//                    if (node.right != null) tmp.add(node.right);
//                }
//                queue = tmp;
//                res++;
//            }
//            return res;
        }
         public static void preOrder(TreeNode root){
             if(root == null) return;
             System.out.print(root.val + " ");
             preOrder(root.left);
             preOrder(root.right);
         }

         public static void inOrder(TreeNode root){
             if(root == null) return;
             inOrder(root.left);
             System.out.print(root.val + " ");
             inOrder(root.right);
         }

         public static void postOrder(TreeNode root){
             if(root == null) return;
             postOrder(root.left);
             postOrder(root.right);
             System.out.print(root.val + " ");
         }
    }
    List<Integer> res = new ArrayList<>();
    @Test
    public void testTree(){
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeOpr.init(nums);

        TreeOpr.inOrder(root);
    }
    @Test
    public void isSymmetric(){
        Integer[] nums = {1,2,2,3,4,4,3};

        TreeNode root = TreeOpr.init(nums);
        System.out.println(check(root.left,root.right));
    }
    boolean check(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return check(left.left,right.right) && check(left.right,right.left);
    }
}
