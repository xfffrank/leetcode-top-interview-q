

// 解法一
class SolutionOne {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false; // prerequisites could be none.

        int[] indegree = new int[numCourses];
        List<Integer>[] preToReady = new List[numCourses];

        for (int i = 0; i < preToReady.length; i++) {
            preToReady[i] = new ArrayList<Integer>();
        }

        // record the number of indegree for each node
        for (int[] pair: prerequisites) {
            // pair[1]: prerequisite, pair[0]: dependant
            indegree[pair[0]]++;
            preToReady[pair[1]].add(pair[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            // Add the nodes that have no indegrees,
            // which means that they don't have prerequisites.
            if (indegree[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            for (int dependant: preToReady[course]) {
                if (--indegree[dependant] == 0)
                    // The course is ready when all of its dependencies
                    // are removed.
                    queue.offer(dependant);
            }
        }

        return numCourses == 0;
    }
}


// 解法二
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph[course].add(pre);
        }

        int[] visited = new int[numCourses];
        // 0: not visited, 1: visiting, 2: visited

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited))
                return false;
        }
        return true;
    }

    private boolean dfs(int node, List<Integer>[] graph, int[] visited) {
        // Use dfs to detect if there is a cycle in the graph
        // Return true if a cycle exists.
        if (visited[node] == 1) return true;
        if (visited[node] == 2) return false;

        visited[node] = 1;
        for (int i = 0; i < graph[node].size(); i++) {
            // visit all neighbors
            if (dfs(graph[node].get(i), graph, visited))
                return true;
        }
        visited[node] = 2;
        return false;
    }
}