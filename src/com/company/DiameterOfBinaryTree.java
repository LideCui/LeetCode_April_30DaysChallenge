package com.company;

/**
 * date: 2020/Apr/11
 * Problem #11 :
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 */

/*
 * Thinking:
 * calculate deepest right and left path of each node.
 * Plus them together and keep track of the longest path which is p[right] + p[left], store it inro memory
 * we can use D&C to improve calculation time
 */

public class DiameterOfBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
     }

    /**
     * @auther Lide Cui
     * @param root represent a tree
     * @return the length of longest path
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int path =0;
        path = Math.max(path, longest(root)[1]);
        return path;
    }

    private int[] longest(TreeNode n){

        int[] ans = {0,0}; // ans[ lon: longest-subbranch, curP: cur-longest-path]
        if(n==null) return ans;

        int[] ansL = new int[2];
        int[] ansR = new int[2];
        int l;
        int r;

        if(n.left==null){
            ansL[0]=0;
        } else {
            ansL = longest(n.left);
            ansL[0]++;
        }
        if(n.right==null){
            ansR[0]=0;
        } else{
            ansR = longest(n.right);
            ansR[0]++;
        }
        int lon = ansR[0]>=ansL[0]?ansR[0]:ansL[0];
        ans[0] = lon;

        int curP = ansR[0]+ansL[0];
        curP = curP>= ansL[1]?curP:ansL[1];
        curP = curP>=ansR[1]?curP:ansR[1];
        ans[1]=curP;

        return ans;
    }

    /*
     * result: 2 submissions
     * After add path = 0 when no node, code passed at second time
     * it beats 100% submission. But I see more concise code
     */
//    int ans;
//    public int diameterOfBinaryTree(TreeNode root) {
//        ans = 1;
//        depth(root);
//        return ans - 1;
//    }
//    public int depth(TreeNode node) {
//        if (node == null) return 0;
//        int L = depth(node.left);
//        int R = depth(node.right);
//        ans = Math.max(ans, L+R+1);
//        return Math.max(L, R) + 1;
//    }
}
