package com.aritra.contests.leetcode;
import java.util.*;
/*
 * 207. Course Schedule
 *
 * Description:
 * There are numCourses courses labeled from 0 to numCourses - 1. You are given
 * prerequisites where prerequisites[i] = [ai, bi] means you must take course bi
 * before course ai. Return true if you can finish all courses.
 *
 * Constraints:
 * - 1 <= numCourses <= 2000
 * - 0 <= prerequisites.length <= 5000
 * - prerequisites[i].length == 2
 * - 0 <= ai, bi < numCourses
 * - ai != bi
 *
 * Example 1:
 * numCourses = 2, prerequisites = [[1,0]] -> true
 * Example 2:
 * numCourses = 2, prerequisites = [[1,0],[0,1]] -> false
 * Example 3:
 * numCourses = 5, prerequisites = [[1,4],[2,4],[3,1],[3,2]] -> true
 */
public class LC207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] p : prerequisites) {
            graph[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for (int next : graph[curr]) {
                if (--inDegree[next] == 0) queue.offer(next);
            }
        }
        return count == numCourses;
    }
}
