package LeetCode;
import java.util.*;
/*
 * Problem 133. Clone Graph
 *
 * Description:
 *   Given a reference of a node in a connected, undirected graph, return a
 *   deep copy (clone) of the graph. Each node in the graph contains a value
 *   (int) and a list (List<Node>) of its neighbors.
 *
 *   class Node {
 *       public int val;
 *       public List<Node> neighbors;
 *   }
 *
 *   The graph is represented in the test as an adjacency list where
 *   adjList[i] is the list of neighbors of the i-th node (1-indexed).
 *   Node values equal their 1-indexed position.
 *
 * Constraints:
 *   - The number of nodes in the graph is in the range [0, 100].
 *   - 1 <= Node.val <= 100
 *   - Node.val is unique for each node.
 *   - There are no repeated edges and no self-loops.
 *   - The graph is connected and all nodes can be visited starting from the
 *     given node.
 *
 * Input:  Node node  (reference to any node in the connected undirected graph;
 *                     null if the graph is empty)
 * Output: Node       (reference to the corresponding node in the cloned graph)
 */
public class LC133_Clone_Graph {
    // -------------------------------------------------------------------------
    // Node definition (matches LeetCode's inner class)
    // -------------------------------------------------------------------------
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

    // -------------------------------------------------------------------------
    // LeetCode method (to be implemented)
    // -------------------------------------------------------------------------

    
    
    // -------------------------------------------------------------------------
    // Helper – build graph from adjacency list (1-indexed values)
    // -------------------------------------------------------------------------
    private static Node buildGraph(int[][] adjList) {
        if (adjList == null || adjList.length == 0) return null;
        Node[] nodes = new Node[adjList.length + 1];
        for (int i = 1; i <= adjList.length; i++) nodes[i] = new Node(i);
        for (int i = 0; i < adjList.length; i++) {
            for (int neighbor : adjList[i]) {
                nodes[i + 1].neighbors.add(nodes[neighbor]);
            }
        }
        return nodes[1];
    }

    // -------------------------------------------------------------------------
    // Helper – verify deep copy (no shared references, identical structure)
    // -------------------------------------------------------------------------
    private static boolean verifyClone(Node original, Node clone,
                                       Set<Integer> visited) {
        if (original == null && clone == null) return true;
        if (original == null || clone == null) return false;
        if (original == clone) return false;                // shared reference!
        if (original.val != clone.val) return false;
        if (original.neighbors.size() != clone.neighbors.size()) return false;
        if (visited.contains(original.val)) return true;
        visited.add(original.val);
        for (int i = 0; i < original.neighbors.size(); i++) {
            if (!verifyClone(original.neighbors.get(i),
                             clone.neighbors.get(i), visited)) return false;
        }
        return true;
    }

    // -------------------------------------------------------------------------
    // Test harness
    // -------------------------------------------------------------------------
    private static void runTest(String label, Node input, boolean expectNull) {
        LC133_Clone_Graph solver = new LC133_Clone_Graph();
        try {
            Node result = solver.cloneGraph(input);
            if (expectNull) {
                System.out.println(label + ": " + (result == null ? "PASS" : "FAIL"));
                return;
            }
            boolean ok = verifyClone(input, result, new HashSet<>());
            System.out.println(label + ": " + (ok ? "PASS" : "FAIL"));
        } catch (UnsupportedOperationException e) {
            System.out.println(label + ": SKIPPED");
        }
    }

    public static void main(String[] args) {
        // Test 1: adjList = [[2,4],[1,3],[2,4],[1,3]]
        //         4-node cycle: 1-2-3-4-1 + diagonals 1-4, 2-3 neighbours
        int[][] adj1 = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        runTest("Test 1 (4-node graph)", buildGraph(adj1), false);

        // Test 2: adjList = [[]]  – single node, no neighbours
        int[][] adj2 = {{}};
        runTest("Test 2 (single node)", buildGraph(adj2), false);

        // Test 3: null input – empty graph
        runTest("Test 3 (null / empty graph)", null, true);
    }
}
