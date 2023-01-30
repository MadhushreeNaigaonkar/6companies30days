package Adobe;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Pair{
    int f,s;
    Pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}

class Solution {

    int count;
    public int averageOfSubtree(TreeNode root) {
        count = 0;
        isAverageBT(root);
        return count;
    }

    public Pair isAverageBT(TreeNode root){
        if(root==null){
            return new Pair(0,0);
        }
        Pair left = isAverageBT(root.left);
        Pair right = isAverageBT(root.right);
        int sum = root.val + left.f + right.f;
        int number = 1 + left.s + right.s;
        if(sum/number == root.val){
            count++;
        } 
        return new Pair(sum,number);
    }

}