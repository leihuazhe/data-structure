package org.ican.perms;


import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-25 12:53 PM
 * <p>
 * leetcode No.46
 * <p>
 * 使用回溯算法解答
 */
public class PermsTest {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> per = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = false;
        }
        perms(nums, 0, per, res, used);


        return res;

    }


    private void perms(int[] nums, int index, List<Integer> per, List<List<Integer>> res, boolean[] used) {
        //已找出一种组合
        if (index == nums.length) {
            System.out.println("rounder:" + index + ", per: " + per.toString());
            res.add(new ArrayList<>(per));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                per.add(nums[i]);
                //
                perms(nums, index + 1, per, res, used);
                per.remove(per.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermsTest permsTest = new PermsTest();

        List<List<Integer>> permute = permsTest.permute(new int[]{1, 3, 2});

        System.out.println(permute.toString());
    }

}
