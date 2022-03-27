package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Subtree {

    static ArrayList<ArrayList<Integer>>adjlist = new ArrayList<ArrayList<Integer>>();
    static Scanner sc = new Scanner(System.in);

    static int[]subtree_sum = new int [12];
    static int[]evencount = new int [12];
   


    public static void main(String[] args) {

        for(int i=0;i<=6;i++){
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

        
    }

    
    static void dfs(int vertex){

        subtree_sum[vertex] += vertex;
        if(vertex%2 == 0){
            evencount[vertex]++;
        }

        for(int child : adjlist.get(vertex)){

            dfs(child);

            subtree_sum[vertex] += subtree_sum[child];
            evencount[vertex] += evencount[child];
        }
    }


    
}
