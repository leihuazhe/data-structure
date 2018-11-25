package org.ican.recurive.combina;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 77
 * C 2
 * C4
 *
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-25 1:21 PM
 */
public class Combinations {


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        List<Integer> cPer = new ArrayList<>();
        combinations(n, k, 1, cPer, res);


        return null;
    }

    /**
     * 起始的 start
     */
    void combinations(int n, int k, int start, List<Integer> cPer, List<List<Integer>> res) {
        if (cPer.size() == k) {
            res.add(new ArrayList<>(cPer));
            return;
        }

//        for (int i = start; i <= n; i++) {
        for (int i = start; i <= n - (k - cPer.size()) + 1; i++) {
            cPer.add(i);
            combinations(n, k, i + 1, cPer, res);
            cPer.remove(cPer.size() - 1);
        }


    }


    /**
     * 39题
     *
     * 40题
     *
     * 216题
     *
     * 78题
     *
     * 90题
     *
     * 401题
     */

}
