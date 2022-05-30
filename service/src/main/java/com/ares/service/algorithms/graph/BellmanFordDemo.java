package com.ares.service.algorithms.graph;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 贝尔曼-福特算法
 *
 * @author fansheng
 * @date 2022/3/15
 */
public class BellmanFordDemo {

    public static void main(String[] args) {

        Edge ab = new Edge("A", "B", 9);
        Edge ac = new Edge("A", "C", 2);
        Edge ba = new Edge("B", "A", 9);
        Edge bc = new Edge("B", "C", 6);
        Edge bd = new Edge("B", "D", 3);
        Edge be = new Edge("B", "E", 1);
        Edge ca = new Edge("C", "A", 2);
        Edge cb = new Edge("C", "B", 6);
        Edge cd = new Edge("C", "D", 2);
        Edge cf = new Edge("C", "F", 9);
        Edge db = new Edge("D", "B", 3);
        Edge dc = new Edge("D", "C", 2);
        Edge de = new Edge("D", "E", 5);
        Edge df = new Edge("D", "F", 6);
        Edge eb = new Edge("E", "B", 1);
        Edge ed = new Edge("E", "D", 5);
        Edge ef = new Edge("E", "F", 3);
        Edge eg = new Edge("E", "G", 7);
        Edge fc = new Edge("F", "C", 9);
        Edge fd = new Edge("F", "D", 6);
        Edge fe = new Edge("F", "E", 3);
        Edge fg = new Edge("F", "G", 4);
        Edge ge = new Edge("G", "E", 7);
        Edge gf = new Edge("G", "F", 4);

        Edge[] edges = new Edge[]{ab, ac, ba, bc, bd, be, ca, cb, cd, cf, db, dc, de, df, eb, ed, ef, eg, fc, fd, fe, fg, ge, gf};

        // A-G 7个节点
        int nodesLength = 7;

        // 起点到当前节点的权重
        Map<String, Integer> weight = Maps.newHashMap();
        weight.put("A", 0);

        Map<String, String> parentMap = Maps.newHashMap();

        for (int i = 1; i < nodesLength - 1; i++) {
            for (Edge edge : edges) {
                Integer endWeight = weight.get(edge.getEnd());
                Integer startWeight = weight.get(edge.getStart());
                int currentWeight = edge.getWeight() + startWeight;
                if (endWeight == null || currentWeight < endWeight) {
                    weight.put(edge.getEnd(), currentWeight);
                    parentMap.put(edge.getEnd(), edge.getStart());
                }
            }
        }

        String parentKey = "G";
        Queue<String> way = new LinkedList<>();
        while (parentKey != null) {
            way.offer(parentKey);
            parentKey = parentMap.get(parentKey);
        }
        System.out.println(way);
        System.out.println(weight.get("G"));
    }

    /**
     * 边
     */
    @Getter
    @AllArgsConstructor
    private static class Edge {

        /**
         * 起点
         */
        private final String start;

        /**
         * 终点
         */
        private final String end;

        /**
         * 起点到终点的权重
         */
        private final int weight;

    }

}
