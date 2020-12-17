package com.ares.service.algorithms.graph;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * 图
 *
 * @author fansheng
 * @date 2020/12/16
 */
public class GraphDemo {

    public static void main(String[] args) {
        Map<String, List<String>> graph = Maps.newHashMap();
        graph.put("you", Lists.newArrayList("alice", "bob", "claire"));
        graph.put("bob", Lists.newArrayList("anuj", "peggy"));
        graph.put("alice", Lists.newArrayList("peggy"));
        graph.put("claire", Lists.newArrayList("tommy", "jonny"));
        graph.put("tommy", Lists.newArrayList("thom"));
        algorithms1(graph);
    }

    /**
     * 广度优先搜索，适用于两类场景：
     * 第一类问题：从节点A出发，有前往节点B的路径吗？
     * 第二类问题：从节点A出发，前往节点B的哪条路径最短？
     */
    private static void algorithms1(Map<String, List<String>> graph) {
        /*
         * 算法要点：始终要先检查相邻的节点是否为目标节点，才能保证到达目标的路径最短
         */
        Node you = new Node("you");
        Queue<Node> queue = new LinkedList<>();
        CollectionUtils.emptyIfNull(graph.get(you.getName())).forEach(n -> queue.add(new Node(n, you)));
        // 保存已检索过的节点，已检索过的节点无需再次检索，避免无限循环
        Set<String> searched = Sets.newHashSet();
        Node goal = null;
        while (!queue.isEmpty()) {
            Node inner = queue.poll();
            String name = inner.getName();
            if (searched.contains(name)) {
                continue;
            }
            if (isGoal(name)) {
                goal = inner;
                break;
            }
            searched.add(name);
            CollectionUtils.emptyIfNull(graph.get(name)).forEach(n -> queue.add(new Node(n, inner)));
        }
        if (goal != null) {
            printGoal(goal);
        }
    }

    /**
     * 判断是否是目标的名称，模拟以 m 结尾的名字为要寻找的目标
     */
    private static boolean isGoal(String name) {
        return name.endsWith("m");
    }

    /**
     * 打印目标节点
     */
    private static void printGoal(Node goal) {
        Node currentNode = goal;
        StringBuilder sb = new StringBuilder(currentNode.getName());
        while (currentNode.getParent() != null) {
            currentNode = currentNode.getParent();
            sb.insert(0, " --> ").insert(0, currentNode.getName());
        }
        System.out.println(sb);
    }

    @Getter
    @AllArgsConstructor
    private static class Node {

        /**
         * 节点名称
         */
        private final String name;

        /**
         * 父节点
         */
        private final Node parent;

        public Node(String name) {
            this.name = name;
            parent = null;
        }
    }

}
