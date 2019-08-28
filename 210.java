class Solution {

    int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph[pre].add(course);
        }

        int[] visited = new int[numCourses];
        int[] result = new int[numCourses];
        index = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited, result))
                return new int[0];
        }

        return result;
    }

    private boolean dfs(int node, List<Integer>[] graph, int[] visited, int[] result) {
        if (visited[node] == 1) return true;
        if (visited[node] == 2) return false;

        visited[node] = 1;
        for (int i = 0; i < graph[node].size(); i++) {
            if (dfs(graph[node].get(i), graph, visited, result))
                return true;
        }

        visited[node] = 2;
        result[index--] = node;
        return false;
    }
}