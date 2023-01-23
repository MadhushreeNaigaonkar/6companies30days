package Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.w3c.dom.Node;

class Solution {
    record Node (int i, int t) {}
    public int networkDelayTime(int[][] times, int n, int k) {
        // create graph
        List<Node>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (var t : times) g[t[0]-1].add(new Node(t[1]-1, t[2]));

        Queue<Node> q = new PriorityQueue<>((a, b) -> a.t - b.t);
        q.offer(new Node(--k, 0));
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;

        while (!q.isEmpty()) {
            var cur = q.poll();
            for (var next : g[cur.i]) {
                int t2 = cur.t + next.t;
                if (t2 >= time[next.i]) continue;
                time[next.i] = t2;
                q.offer(new Node(next.i, t2));
            }
        }

        int res = time[0];
        for (var t : time) if (t == Integer.MAX_VALUE) return -1; else if (t > res) res = t;
        return res;
    }
}
