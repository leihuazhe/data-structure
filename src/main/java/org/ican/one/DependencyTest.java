package org.ican.one;

import java.util.*;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-11-22 2:47 PM
 */
public class DependencyTest {


    /**
     * 当前项目的parent 和 children
     */
    private static class Node {
        String target;
        List<String> parents = new ArrayList<>();

        List<String> children = new ArrayList<>();

        public Node(String target) {
            this.target = target;
        }
    }

    /**
     * 存储项目依赖的数据结构， key -> value
     * key 依赖于 value
     */
    public static class Pair {

        private String key;

        public String getKey() {
            return key;
        }

        private String value;

        public String getValue() {
            return value;
        }


        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    /**
     * 输入 target，输出 target的依赖项和间接依赖项。 以及 依赖和间接依赖 target的项目
     */
    public List<String> checkDependency(List<String> projects, List<Pair> dependList, String target) {
        List<String> compilerList = new ArrayList<>();
        check(projects, dependList, target, compilerList);

        return compilerList;
    }

    public List<String> check(List<String> projects, List<Pair> dependList, String target, List<String> compilerList) {
        Node targetNode = new Node(target);
        if (!compilerList.contains(target)) {
            compilerList.add(targetNode.target);
        }
        for (Pair pair : dependList) {
            if (pair.getKey().equals(target)) {
                targetNode.children.add(pair.getValue());
            }
            if (pair.getValue().equals(target)) {
                targetNode.parents.add(pair.getKey());
            }
        }
        if (targetNode.children.size() == 0) {
            return compilerList;
        }
        for (String child : targetNode.children) {
            check(projects, dependList, child, compilerList);
        }

        for (String parent : targetNode.parents) {
            if (compilerList.contains(parent)) {
                return compilerList;
            }
            check(projects, dependList, parent, compilerList);

        }

        return compilerList;
    }


    public static void main(String[] args) {
        DependencyTest test = new DependencyTest();
        List<Pair> dependList = new ArrayList<>();
        dependList.add(new Pair("A", "B"));
        dependList.add(new Pair("E", "A"));
        dependList.add(new Pair("F", "A"));
        dependList.add(new Pair("F", "E"));
        dependList.add(new Pair("B", "C"));
        dependList.add(new Pair("B", "D"));
        dependList.add(new Pair("C", "D"));
        dependList.add(new Pair("G", "H"));

        List<String> check = test.checkDependency(Arrays.asList("A", "B", "C", "D","E","F","G"), dependList, "A");

        System.out.println(check);
    }
}
