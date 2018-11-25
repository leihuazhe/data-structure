package org.ican.recurive;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-24 11:49 PM
 */
public class ValidateBst98 {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode node, Integer lowerBound, Integer uppenBound) {
        if (node == null) {
            return true;
        }

        if (lowerBound != null && node.val <= lowerBound) {
            return false;
        }
        if (uppenBound != null && node.val >= uppenBound) {
            return false;
        }

        boolean leftBST = isValidBST(node.left, lowerBound, node.val);
        boolean rightBST = isValidBST(node.right, node.val, uppenBound);
        return leftBST && rightBST;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        theInOrderTraversal(root);

        boolean validBST = isValidBST(root);

        System.out.println("isValidBST: " + validBST);

    }

    public static void theInOrderTraversal(TreeNode root) {  //中序遍历
        if (root.left != null) {
            theInOrderTraversal(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            theInOrderTraversal(root.right);
        }
    }

}

