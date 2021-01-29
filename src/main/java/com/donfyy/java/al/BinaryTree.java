package com.donfyy.java.al;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /**
     * 层次遍历
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     *
     * @param pRoot 根节点
     * @return arrayLists
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

    ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        dfs(ret, 0, pRoot);
        return ret;
    }

    private void dfs(ArrayList<ArrayList<Integer>> ret, int level, TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }

        if (level == ret.size()) {
            ret.add(new ArrayList<>());
        }

        ret.get(level).add(pRoot.val);
        dfs(ret, level + 1, pRoot.left);
        dfs(ret, level + 1, pRoot.right);
    }
}
