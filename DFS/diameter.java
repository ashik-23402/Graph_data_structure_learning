package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class diameter {

    
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

        int mx_depth = -1;
        int mx_node=-1;

        for(int i=0;i<n;i++){
            if(mx_depth<depth[i]){
                mx_depth = depth[i];
                mx_node = i;
            }
            depth[i] = 0;

        }

        dfs(mx_node, 0);

        mx_depth=-1;

        for(int i=0;i<n;i++){
            if(mx_depth<depth[i]){
                mx_depth = depth[i];
               
            }
            

        }

        System.out.println(mx_depth);


        
        
    }

    static void dfs(int vertex,int parent){

        

        for(int child : adjlist.get(vertex)){

            if(child == parent)continue;
            depth[child] = depth[vertex]+1;

            dfs(child, vertex);
        }


    }

    //tecchnic ---jekono node ke root hishebe max path find kore 
    //max path node theke dfs call kore depth find krte hbe.
    
}
