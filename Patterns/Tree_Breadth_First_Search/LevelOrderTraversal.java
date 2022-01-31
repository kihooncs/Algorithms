package Patterns.Tree_Breadth_First_Search;

import com.sun.source.tree.Tree;

import java.util.*;

/*
 * Problem Statement: Given a binary tree, populate an array to represent its level-by-level traversal.
 * You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 *
 * Score: 10/10
 */
public class LevelOrderTraversal {
    public static List<List<Integer>> traverseBF(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while (nodes.size() > 0) {
                int currSize = nodes.size();
                List<Integer> temp = new ArrayList<>();
                while (currSize > 0) {
                    TreeNode curr = nodes.remove();
                    temp.add(curr.val);
                    if (curr.left != null) {
                        nodes.add(curr.left);
                    }
                    if (curr.right != null) {
                        nodes.add(curr.right);
                    }
                    currSize--;
                }
                result.add(temp);
            }
        }

        return result;
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // add the node to the current level
                currentLevel.add(currentNode.val);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        bruteForce();
        //solution();
    }

    public static void bruteForce() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverseBF(root);
        System.out.println("Level order traversal: " + result);
    }

    public static void solution() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
