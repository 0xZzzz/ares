package com.ares.service.algorithms.graph;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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
        graph.put("claire", Lists.newArrayList("thom", "jonny"));
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
        Deque<String> deque = new LinkedList<>(graph.get("you"));
        Set<String> searched = Sets.newHashSet();
        while (!deque.isEmpty()) {
            String name = deque.pop();
            if (searched.contains(name)) {
                continue;
            }
            if (isGoal(name)) {
                System.out.println(name);
                return;
            }
            searched.add(name);
            List<String> neighbors = graph.get(name);
            if (CollectionUtils.isNotEmpty(neighbors)) {
                deque.addAll(neighbors);
            }
        }
    }

    /**
     * 判断是否是目标的名称，模拟以 m 结尾的名字为要寻找的目标
     */
    private static boolean isGoal(String name) {
        return name.endsWith("m");
    }

}
