package org.ican.recurive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-24 10:19 PM
 */
public class BinaryTreePaths257 {


    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            if (root == null)
                return res;

            if (root.left == null && root.right == null) {
                res.add(String.valueOf(root.val));
            }

            List<String> leftS = binaryTreePaths(root.left);
            List<String> rightS = binaryTreePaths(root.right);

            for (int i = 0; i < leftS.size(); i++) {
                res.add(root.val + "->" + leftS.get(i));

            }

            for (int i = 0; i < rightS.size(); i++) {
                res.add(root.val + "->" + rightS.get(i));
            }
            return res;
        }
    }
}
