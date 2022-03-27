package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class connected {

    static boolean [] visited = new boolean[10];
    static ArrayList<ArrayList<Integer>>adjlist = new ArrayList<ArrayList<Integer>>();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>>cc = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer>current_cc = new ArrayList<>();

    public static void main(String[] args) {

        for(int i=0;i<=6;i++){
            adjlist.add(new ArrayList<Integer>());
            cc.add(new ArrayList<Integer>());
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

        int cnt =0;

        for(int i=1;i<=n;i++){
            if(visited[i]) continue;
            current_cc.clear();
            dfs(i);
            cc.add(current_cc);
            cnt++;
        }

        System.out.println(cnt);

        for(ArrayList<Integer>a : cc){
            if(a.size()>0){
                System.out.println(a);
            }
        }

        
    }

    static void dfs(int vertex){
        if(visited[vertex]) return;
        visited[vertex] = true;
        current_cc.add(vertex);

        for(int child : adjlist.get(vertex)){
            dfs(child);
        }
    }


// time complexity O(v+e)

    
}
