package BFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class shortestpath01 {

    static ArrayList<ArrayList<Pair>> adjlist = new ArrayList<ArrayList<Pair>>();
    static ArrayList<Integer> lvl = new ArrayList<Integer>();
    static Scanner sc = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            adjlist.add(new ArrayList<>());

            
        }



         n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0;i<m;i++){
            int x= sc.nextInt();
            int y = sc.nextInt();

            adjlist.get(x).add(new Pair<Integer,Integer>(y, 0));
            adjlist.get(y).add(new Pair<Integer,Integer>(x, 0));

            System.out.println(bfs());


        }
       
    }

    static int bfs(){
        Deque<Integer>dq = new LinkedList<>();
        dq.offer(1);
        lvl.set(1, 0);

        while(!dq.isEmpty()){
            int cur_v = dq.poll();

            for(Pair child : adjlist.get(cur_v)){
                int child_v = (int) child.first;
                int wt = (int) child.second;

                if((lvl.get(cur_v)+wt)< lvl.get(child_v)){
                    lvl.set(child_v, lvl.get(cur_v)+wt);
                    if(wt == 1){
                        dq.offer(child_v);
                    }
                    else{
                        dq.offerFirst(child_v);
                    }
                }    

            }
        }

        return lvl.get(n)==Integer.MAX_VALUE ? -1:lvl.get(n);

    }
    
}
