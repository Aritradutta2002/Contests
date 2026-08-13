package com.leetcode;

import java.util.*;

/*
 * 133. Clone Graph
 *
 * Description:
 * Given a reference of a node in a connected undirected graph, return a deep copy of the graph.
 */
public class LC133_Clone_Graph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() { val = 0; neighbors = new ArrayList<>(); }
    public Node(int _val) { val = _val; neighbors = new ArrayList<>(); }
    public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        q.offer(node);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                map.get(curr.val).neighbors.add(map.get(neighbor.val));
            }
        }
        return copy;
    }
}
