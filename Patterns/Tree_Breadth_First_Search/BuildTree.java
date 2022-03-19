package Patterns.Tree_Breadth_First_Search;

public class BuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        TreeNode result = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return result;
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode curr = new TreeNode(preorder[preStart]);
        int mid = preStart;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == curr.val) {
                mid = i;
                break;
            }
        }
        curr.left = buildTree(preorder, preStart + 1, mid, inorder, inStart, mid - 1);
        curr.right = buildTree(preorder, mid + 1, preEnd, inorder, mid + 1, inEnd);
        return curr;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 3};
        int[] in = new int[]{1, 2, 3};
        buildTree(pre, in);
    }
}
