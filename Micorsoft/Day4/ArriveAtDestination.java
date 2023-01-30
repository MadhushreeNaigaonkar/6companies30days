package Micorsoft;
import java.util.*;
class Solution {
    static class Edge{
        int vtc;
        int nbr;
        int wt;
        Edge(int vtc,int nbr,int wt){
            this.vtc=vtc;
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    static class Pair implements Comparable<Pair>{
        int vtc;
        int wt;
        Pair(int vtc,int wt){
            this.vtc=vtc;
            this.wt=wt;
        }
        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int mod=(int)Math.pow(10,9)+7;
        ArrayList<Edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<roads.length;i++){
            graph[roads[i][0]].add(new Edge(roads[i][0],roads[i][1],roads[i][2]));
            graph[roads[i][1]].add(new Edge(roads[i][1],roads[i][0],roads[i][2]));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        int count[]=new int[n];
        count[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));

        while(pq.size()>0){
            Pair rm=pq.remove();


            for(Edge e:graph[rm.vtc]){
                if((rm.wt+e.wt)<dist[e.nbr]){
                    dist[e.nbr]=rm.wt+e.wt;
                    pq.add(new Pair(e.nbr,dist[e.nbr]));
                    count[e.nbr]=count[rm.vtc];
                }
                else if((rm.wt+e.wt==dist[e.nbr])){
                    count[e.nbr]=(count[e.nbr]+count[rm.vtc])%mod;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(dist[i]);
        }
        return (int)(count[n-1]%mod);
    }
}
