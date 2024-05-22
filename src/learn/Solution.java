package learn;

/**
 * @Author: Bennett
 * @Date: 2024/05/21/18:37
 * @Description:
 */
class Solution {

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        new Solution().findRedundantConnection(edges);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    private void union(int[] parent, int node1, int node2) {
        parent[find(parent, node1)] = find(parent, node2);
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}
