package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class LCA {

    static ArrayList<ArrayList<Integer>>adjlist = new ArrayList<ArrayList<Integer>>();
    static int []parent = new int[10];
    static Scanner sc = new Scanner(System.in);
    

    public static void main(String[] args) {

        for(int i=0;i<=10;i++){
            adjlist.add(new ArrayList<Integer>());
           
        }

        Arrays.fill(parent, 0);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0;i<=m;i++){
            int v = sc.nextInt();
            int d = sc.nextInt();

            adjlist.get(v).add(d);
            adjlist.get(d).add(v);
        }

        dfs(1, 0);

        int x = sc.nextInt();
        int y = sc.nextInt();

        ArrayList<Integer>path_x = new ArrayList<>();
        ArrayList<Integer>path_y = new ArrayList<>();

        path_x = path(x);
        path_y = path(y);

        int min_ln = Math.min(path_x.size(), path_y.size());
        int lca = -1;

        for(int i=0;i<min_ln;i++){
            if(path_x.get(i) == path_y.get(i)){
                lca = path_x.get(i);
            }
            else{
                break;
            }
        }

        System.out.println(lca);

        
    }

    static ArrayList<Integer> path(int v){
        ArrayList<Integer>ans = new ArrayList<>();

        while(v != 0){
            ans.add(v);
            v = parent[v];
        }

        Collections.reverse(ans);

        return ans;
    }




    static void dfs(int vertex,int p){
        parent[vertex] = p;

        for(int child:adjlist.get(vertex)){

            if(child == p) continue;
            dfs(child, vertex);

        }
    }
    
}
