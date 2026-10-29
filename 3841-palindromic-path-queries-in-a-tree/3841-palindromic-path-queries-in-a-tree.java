class Solution {
    
    private List<Integer>[] tree;

    private int[] tin;
    private int[] tout;
    private int[][] up;
    private int[] depth;

    private int[] prefix;
    private int[] nodeMask;

    private int timer;
    private int LOG;

    private Fenwick bit;
    
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            tree[u].add(v);
            tree[v].add(u);
        }

        LOG = 1;

        while ((1 << LOG) <= n) {
            LOG++;
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];

        prefix = new int[n];
        nodeMask = new int[n];

        up = new int[n][LOG];

        for (int i = 0; i < n; i++) {
            nodeMask[i] = 1 << (s.charAt(i) - 'a');
        }

        timer = 0;

        dfs(0, 0, 0);

        bit = new Fenwick(n + 2);

        List<Boolean> result = new ArrayList<>();

        for (String query : queries) {

            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {

                int node = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);

                int oldMask = nodeMask[node];
                int newMask = 1 << (newChar - 'a');

                int delta = oldMask ^ newMask;

                if (delta != 0) {

                    // All descendants' root-prefix XOR changes
                    bit.rangeUpdate(
                            tin[node],
                            tout[node],
                            delta
                    );

                    nodeMask[node] = newMask;
                }

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lca = getLCA(u, v);

                int xorU =
                        prefix[u] ^ bit.query(tin[u]);

                int xorV =
                        prefix[v] ^ bit.query(tin[v]);

                int pathMask =
                        xorU ^
                        xorV ^
                        nodeMask[lca];

                // At most one odd-frequency character
                boolean possible =
                        pathMask == 0 ||
                        (pathMask & (pathMask - 1)) == 0;

                result.add(possible);
            }
        }

        List<Boolean> answer = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            answer.add(result.get(i));
        }

        return answer;


    }

     private void dfs(
            int node,
            int parent,
            int parentPrefix) {

        tin[node] = ++timer;

        up[node][0] = parent;

        for (int j = 1; j < LOG; j++) {
            up[node][j] =
                    up[up[node][j - 1]][j - 1];
        }

        prefix[node] =
                parentPrefix ^ nodeMask[node];

        for (int next : tree[node]) {

            if (next == parent) {
                continue;
            }

            depth[next] = depth[node] + 1;

            dfs(
                    next,
                    node,
                    prefix[node]
            );
        }

        tout[node] = timer;
    }

    private int getLCA(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {

            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {

            if (up[u][j] != up[v][j]) {

                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }

    class Fenwick {

        int[] tree;

        Fenwick(int n) {
            tree = new int[n + 1];
        }

        private void update(
                int index,
                int value) {

            while (index < tree.length) {

                tree[index] ^= value;

                index += index & -index;
            }
        }

        void rangeUpdate(
                int left,
                int right,
                int value) {

            update(left, value);

            update(right + 1, value);
        }

        int query(int index) {

            int result = 0;

            while (index > 0) {

                result ^= tree[index];

                index -= index & -index;
            }

            return result;
        }
    }
}