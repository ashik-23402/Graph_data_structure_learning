package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dfs {

    static ArrayList<ArrayList<Integer>>adjlist = new ArrayList<ArrayList<Integer>>();
    static Scanner sc = new Scanner(System.in);  

    static boolean []visited = new boolean[10];


    public static void main(String[] args) {
        for(int i=0;i<=6;i++){
            adjlist.add(new ArrayList<Integer>());
        }
        Arrays.fill(visited, false);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0;i<=m;i++){
            int src =sc.nextInt();
            int dst = sc.nextInt();

            adjlist.get(src).add(dst);
            adjlist.get(dst).add(src);
        }

        dfs(1);
        
        
    }


    static void  dfs(int vertex){
        //take action on vertex after entering the vertex
        System.out.println(vertex);
        visited[vertex] = true;
        //if (visited[vertex] == true) return;

        for(int child : adjlist.get(vertex)){
            //take action on child before entering the child node
            System.out.println("par "+ vertex + " child "+ child);
            if(visited[child])continue;
           

            dfs(child);
            //take action on child after exiting the child node
        }

        //take action on child before exiting the child node

    }

    //time complexity O(V+E);
    
}
