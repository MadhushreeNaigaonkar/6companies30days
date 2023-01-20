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

 class State
 {
     int notRob;
     int rob;
 
     State(int notRob, int rob)
     {
         this.notRob = notRob;
         this.rob = rob;
     }
 }
 
 class Solution {
 
     private State dfs(TreeNode root)
     {
         if(root == null) return new State(0, 0);
 
         State left = dfs(root.left);
         
         State right = dfs(root.right);
 
         State node = new State(0, 0);
 
         node.notRob = Math.max(left.rob, left.notRob) + Math.max(right.notRob, right.rob);
         
         node.rob = left.notRob + right.notRob + root.val;
 
         return node;
     }
 
     public int rob(TreeNode root) {
         
         State ans = dfs(root);
 
         return Math.max(ans.rob, ans.notRob);
     }
 }