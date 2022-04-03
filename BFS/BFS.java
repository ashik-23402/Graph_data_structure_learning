package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    static ArrayList<ArrayList<Integer>>adjlist = new ArrayList<ArrayList<Integer>>();
    static int []visited = new int [10];
    static int []level = new int [10];
    
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0;i<=m;i++){
            int src =sc.nextInt();
            int dst = sc.nextInt();

            adjlist.get(src).add(dst);
            adjlist.get(dst).add(src);
        }

        bfs(1);
        
    }


    static void bfs(int source){
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = 1;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            // System.out.println(cur);
            for(int child : adjlist.get(cur)){
                if(visited[child] != 1){
                    queue.offer(child);
                    visited[child] = 1;
                    level[child] = level[cur]+1; //initial root level ->0
                }
                
            }
        }

    }






    
}
