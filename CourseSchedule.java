class Solution {
    private static final int VISITED = 1;
    private static final int EXPLORING = -1;
    private static final int UNVISITED = 0;
    private Deque<Integer> stack;
    private int[] nextCourseToVisit;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] status = new int[numCourses];
        stack = new ArrayDeque<>();
        nextCourseToVisit = new int[numCourses];
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        
        for (int course = 0; course < numCourses; course++) {
            if (status[course] == UNVISITED && hasCycle(course, graph, status)) return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(int curCourse, Map<Integer, List<Integer>> graph, int[] status) {
        stack.push(curCourse);
        while (!stack.isEmpty()) {
            curCourse = stack.peek();
            status[curCourse] = EXPLORING;
            List<Integer> coursesToVisit = graph.getOrDefault(curCourse, new ArrayList<>());
            for (; nextCourseToVisit[curCourse] < coursesToVisit.size(); nextCourseToVisit[curCourse]++) {
                int nextCourse = coursesToVisit.get(nextCourseToVisit[curCourse]);
                if (status[nextCourse] == EXPLORING) return true;
                if (status[nextCourse] == VISITED) continue;
                stack.push(nextCourse);
                break;
            }
            
            if (nextCourseToVisit[curCourse] == coursesToVisit.size()) {
                stack.pop();
                status[curCourse] = VISITED;
            }
        }
        
        return false;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[][] dependencies) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] dependency : dependencies) {
            graph.computeIfAbsent(dependency[1], k->new ArrayList<>()).add(dependency[0]);
        }
        return graph;
    }
}
