package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class EdgeDelete {

    static ArrayList<ArrayList<Integer>>adjlist = new ArrayList<ArrayList<Integer>>();
    static int []subtree_sum = new int[10];
    static int [] val = new int[10];
    static final int m = (int) 1e9+7;
    
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        for(int i=0;i<=10;i++){
            adjlist.add(new ArrayList<Integer>());
           
        }

      
        

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0;i<=m;i++){
            int src =sc.nextInt();
            int dst = sc.nextInt();

            adjlist.get(src).add(dst);
            adjlist.get(dst).add(src);
        }

        dfs(1, 0);

        long ans =0;

        for(int i=2;i<=n;i++){
            int part1 = subtree_sum[i];
            int part2 = subtree_sum[1]-part1;
            ans = Math.max(ans, (part1*part2))%m;
        }

        System.out.println(ans);

        
    }

    static void dfs(int vertex, int p){

        subtree_sum[vertex] += val[vertex];

        for(int child : adjlist.get(vertex)){
            if(child == p) continue;

            dfs(child, vertex);
            subtree_sum[vertex] += subtree_sum[child];
        }
    }
    
}
