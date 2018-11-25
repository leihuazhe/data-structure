package org.ican.recurive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-24 10:38 PM
 */
public class PathSum113 {


    static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null)
                return res;

            List<Integer> tres = new ArrayList<>();
            dfs(root, tres, 0, sum, res);
            return res;
        }

        private void dfs(TreeNode node, List<Integer> tres, int tsum, int sum, List<List<Integer>> res) {
            tres.add(node.val);
            tsum += node.val;

            if (node.left == null && node.right == null) {
                if (tsum == sum)
//                    res.add(tres);
                    res.add(new ArrayList<>(tres));
            } else {
                if (node.left != null)
                    dfs(node.left, tres, tsum, sum, res);

                if (node.right != null)
                    dfs(node.right, tres, tsum, sum, res);
            }
            tres.remove(tres.size() - 1);
            return;
        }
    }
}
