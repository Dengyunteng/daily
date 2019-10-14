package cn.alogi;

import java.util.LinkedList;

public class 图的搜索 {
    public static Graph graph;
    public static void bfs(int s, int t){
        if(s == t) return;
        boolean[] visited = new boolean[graph.v];
        visited[s] = true;
        int[] pre = new int[graph.v];
        for(int i = 0; i < pre.length; i++){
            pre[i] = -1;
        }
        LinkedList<Integer> queen = new LinkedList<>();
        queen.add(s);
        while(!queen.isEmpty()){
            int temp = queen.poll();
            for(int i = 0; i < graph.adj[temp].size(); i++){
                int p = graph.adj[temp].get(i);
                if(!visited[p]){
                    pre[p] = temp;
                    if(p == t){
                        print(pre, s, t);
                        return;
                    }
                    visited[p] = true;
                    queen.add(p);
                }
            }
        }
    }

    public static void print(int[] print, int s, int t){
        if(print[t] != -1 && s != t){
            print(print, s, print[t]);
        }
        System.out.println(t);
    }
    public static boolean found = false;
    public static void dfs(int s, int t){
        found = false;
        boolean[] visited = new boolean[graph.v];
        int[] pre = new int[graph.v];
        for(int i = 0; i < pre.length; i++){
            pre[i] = -1;
        }
        recurDfs(s, t, visited, pre);
        print(pre, s, t);
    }

    public static void recurDfs(int s, int t, boolean[] visited, int[] pre){
        if(found) return;
        visited[s] = true;
        if(s == t){
            found = true;
            return;
        }
        for(int i = 0; i < graph.adj[s].size(); i++){
            int temp = graph.adj[s].get(i);
            if(!visited[temp]){
                pre[temp] = s;
                recurDfs(temp, t, visited, pre);
            }
        }
    }
}
class Graph{
    public int v;
    public LinkedList<Integer>[] adj;

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t){
        adj[s].add(t);
        adj[t].add(s);
    }
}
