package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Treeheight {

    static ArrayList<ArrayList<Integer>>adjlist = new ArrayList<ArrayList<Integer>>();
    static Scanner sc = new Scanner(System.in);
    static int[]depth = new int[10];
    static int []height = new int [10];
    
    public static void main(String[] args) {
        for(int i=0;i<=10;i++){
            adjlist.add(new ArrayList<Integer>());
           
        }

        Arrays.fill(height, 0);
        Arrays.fill(depth, 0);
        

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0;i<=m;i++){
            int src =sc.nextInt();
            int dst = sc.nextInt();

            adjlist.get(src).add(dst);
            adjlist.get(dst).add(src);
        }

        dfs(1, 0);

        for(int i=0;i<m;i++){
            System.out.println(height[i]+" " + depth[i]);
        }

        
    }


    static void dfs(int vertex, int parent){

        for(int child : adjlist.get(vertex)){
            if(child == parent) continue;
            depth[child] = depth[vertex]+1;
            dfs(child, vertex);
            height[vertex] = Math.max(height[vertex], height[child]+1);
        }
    }
}
