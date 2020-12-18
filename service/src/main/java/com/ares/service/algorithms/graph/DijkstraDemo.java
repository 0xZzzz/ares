package com.ares.service.algorithms.graph;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 迪克斯特拉(Dijkstra)算法
 * <p>
 * 注意：不能将狄克斯特拉算法用于包含负权边的图。在包含负权边的图中，要找出最短路径，可使用另一种算法——贝尔曼-福德算法（Bellman-Ford algorithm）
 *
 * @author fansheng
 * @date 2020/12/17
 */
public class DijkstraDemo {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = Maps.newHashMap();

        Map<String, Integer> musicNeighbors = Maps.newHashMap();
        musicNeighbors.put("disc", 5);
        musicNeighbors.put("poster", 0);
        graph.put("music", musicNeighbors);

        Map<String, Integer> discNeighbors = Maps.newHashMap();
        discNeighbors.put("guitar", 15);
        discNeighbors.put("drum", 20);
        graph.put("disc", discNeighbors);

        Map<String, Integer> posterNeighbors = Maps.newHashMap();
        posterNeighbors.put("guitar", 30);
        posterNeighbors.put("drum", 35);
        graph.put("poster", posterNeighbors);

        Map<String, Integer> guitarNeighbors = Maps.newHashMap();
        guitarNeighbors.put("piano", 20);
        graph.put("guitar", guitarNeighbors);

        Map<String, Integer> drumNeighbors = Maps.newHashMap();
        drumNeighbors.put("piano", 10);
        graph.put("drum", drumNeighbors);

        algorithms(graph);
    }

    private static void algorithms(Map<String, Map<String, Integer>> graph) {
        Queue<String> queue = new LinkedList<>(graph.get("music").keySet());
        // 保存已检索过的节点，已检索过的节点无需再次检索，避免无限循环
        Set<String> searched = Sets.newHashSet();
        // 保存开始节点到其他节点的最少花费
        Map<String, Integer> minCost = Maps.newHashMap();
        // 保存开始节点到达其他节点最少花费时，其他节点的父节点
        Map<String, String> minParent = Maps.newHashMap();
        graph.get("music").forEach((k, v) -> minParent.put(k, "music"));
        minCost.putAll(graph.get("music"));
        while (!queue.isEmpty()) {
            String name = queue.poll();
            if (searched.contains(name)) {
                continue;
            }
            searched.add(name);
            Map<String, Integer> neighbors = graph.get(name);
            if (MapUtils.isNotEmpty(neighbors)) {
                queue.addAll(neighbors.keySet());
                for (Map.Entry<String, Integer> cost : neighbors.entrySet()) {
                    int costMoney = cost.getValue() + minCost.get(name);
                    String parent = name;
                    if (minCost.containsKey(cost.getKey())) {
                        if (costMoney > minCost.get(cost.getKey())) {
                            costMoney = minCost.get(cost.getKey());
                            parent = minParent.get(cost.getKey());
                        }
                    }
                    minCost.put(cost.getKey(), costMoney);
                    minParent.put(cost.getKey(), parent);
                }
            }
        }
        String target = "piano";
        System.out.println("the minimum cost of piano exchange is $" + minCost.get(target));
        StringBuilder sb = new StringBuilder(target);
        while (target != null) {
            String parent = minParent.get(target);
            if (StringUtils.isNotBlank(parent)) {
                sb.insert(0, " --> ").insert(0, parent);
            }
            target = parent;
        }
        System.out.println("exchange path: " + sb);
    }

}
