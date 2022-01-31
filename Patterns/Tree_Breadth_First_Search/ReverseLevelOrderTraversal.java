package Patterns.Tree_Breadth_First_Search;

import java.util.*;

public class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverseBF(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root != null) {
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                int levelSize = nodes.size();
                List<Integer> currList = new ArrayList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode curr = nodes.remove();
                    currList.add(curr.val);
                    if (curr.left != null) {
                        nodes.add(curr.left);
                    }
                    if (curr.right != null) {
                        nodes.add(curr.right);
                    }
                }
                result.add(0, currList);
            }
        }
        return result;
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
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
                // insert the children of current node to the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            // append the current level at the beginning
            result.add(0, currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        bruteForce();
        solution();
    }

    public static void bruteForce() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverseBF(root);
        System.out.println("Reverse level order traversal: " + result);
    }

    public static void solution() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
